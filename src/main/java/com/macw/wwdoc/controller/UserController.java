package com.macw.wwdoc.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.*;
import com.macw.wwdoc.service.*;
import com.macw.wwdoc.util.DigestUtils;
import com.macw.wwdoc.util.IpAddressUtil;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-14
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService iUserService;

    @Resource
    private ILogService iLogService;

    @Resource
    private IQiniuUploadFileService iQiniuUploadFileService;

    @Resource
    private ITeamService iTeamService;

    @Resource
    private IApidetailService iApidetailService;

    @Resource
    private IProjectService iProjectService;

    @Resource
    private ICategoryService iCategoryService;

    @Resource
    private IMailService iMailService;

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView(thyme + "/user/login");
    }

    @RequestMapping("/userLogin")
    public ResultUtil userLogin(String username, String password, String captchaCode) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResultUtil.error(Constant.PARAM_FAIL);
        }
        //判断验证码是否有限
        Session session = getSession();
        if (!captchaCode.equals(session.getAttribute("captchaCode"))) {
            return ResultUtil.error("验证码错误或已过期！");
        }
        //清除session中的验证码
        session.removeAttribute("captchaCode");
        //  1.将用户输入的账号密码 封装在token中
        password = DigestUtils.md5(password);

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        2.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //设置登录时长为永不过期
        subject.getSession().setTimeout(-1000L);
//        3.通过Subject 的login方法 完成登录
        try {
            // 到这里如果没有异常说明登录成功，
            subject.login(token);
            // 将用户对象放到session中
            User user = iUserService.getOne(new QueryWrapper<User>().lambda()
                    .eq(User::getUserName, username)
                    .eq(User::getPassword, password)
                    .eq(User::getState, Constant.ENABLE));
            subject.getSession().setAttribute(Constant.LOGIN_USER, user);
            Log log = new Log();
            log.setLogType("select");
            log.setLogIp(IpAddressUtil.getIp());
            log.setLogDate(LocalDateTime.now());
            log.setLogUserId(user.getUserId());
            log.setLogContent("登录");
            iLogService.save(log);
            return ResultUtil.ok(Constant.LOGIN_SUCCESS_MSG);
        } catch (Exception e) {
            // 有异常说明登录失败，
            logger.debug("登录失败  异常  " + e.getMessage());
            logger.debug("参数 loginName = " + username);
            logger.debug("参数 pwd = " + password);
            return ResultUtil.error(Constant.LOGIN_FAIL_MSG);
        }
    }

    @com.macw.wwdoc.config.Log(value = "退出登录", type = "exit")
    @RequestMapping("/loginLou")
    public ResultUtil loginLou() {
        try {
            getSession().getAttribute(Constant.LOGIN_USER);
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return ResultUtil.success(Constant.LOGIN_OUT);
        } catch (InvalidSessionException e) {
            e.printStackTrace();
            logger.debug("-----------/user/loginLou");
            return ResultUtil.error(Constant.ERROR_MSG);
        }

    }

    /**
     * 生成验证码
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/captcha")
    public void getCaptcha(HttpServletResponse response) throws IOException {
        //官方文档：https://hutool.cn/docs/#/
        //定义图形验证码的长和宽
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);

        //输出code 打印生成的验证码
        logger.debug(captcha.getCode());
        Session session = getSession();
        session.setAttribute("captchaCode", captcha.getCode());
        //图片输出 响应流
        ServletOutputStream outputStream = response.getOutputStream();
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(outputStream);
        //释放资源
        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome() {
        ModelAndView mv = new ModelAndView(thyme + "/welcome");
        mv.addObject("userNumber", iUserService.list().size());
        mv.addObject("teamNumber", iTeamService.list().size());
        mv.addObject("proNumber", iProjectService.list().size());
        mv.addObject("apiNumber", iApidetailService.list().size());
        return mv;
    }

    @RequestMapping("/toSetting")
    public ModelAndView toSetting() {
        User user = getUser();
        ModelAndView mv = new ModelAndView(thyme + "/user/user-setting");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping("/updateUser")
    public ResultUtil updateUser(MultipartFile file, User user,String new_password) {
        if (file != null && file.getSize() > 0) {
            String url = null;
            try {
                url = iQiniuUploadFileService.uploadFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            user.setHeadImage(url);
        }
        if (StringUtils.isNotBlank(user.getPassword())){
            User user1 = getUser();
            if (!user1.getPassword().equals(DigestUtils.md5(user.getPassword()))){
                return ResultUtil.error("原密码错误！");
            }
            user.setUserId(user1.getUserId());
            user.setPassword(DigestUtils.md5(new_password));
        }
        return ResultUtil.flag(iUserService.updateById(user));
    }

    @RequestMapping("/toUpdatePwd")
    public ModelAndView toUpdatePwd(){
        return new ModelAndView(thyme+"/user/user-password");
    }

    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        return new ModelAndView(thyme+"/user/register");
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public ResultUtil register(User user, String captchaCode){
        //判断验证码是否有效
        Session session = getSession();
        if (!session.getAttribute("captchaCode").equals(captchaCode)) {
            return ResultUtil.error("验证码错误或已过期！");
        }
        if (StringUtils.isNotBlank(user.getUserName())){
            User one = iUserService.getOne(new QueryWrapper<User>().lambda()
                    .eq(User::getUserName, user.getUserName()));
            if(one!=null){
                return ResultUtil.error("该用户名账号已被占用！");
            }
        }
        user.setPassword(DigestUtils.md5(user.getPassword()));
        user.setRegisterTime(LocalDateTime.now());
        boolean save = iUserService.save(user);
        if (!save){
            return ResultUtil.error(Constant.REGISTER_FAIL);
        }
            ArrayList<Integer> list = new ArrayList<>();
            list.add(20);
            list.add(21);
            list.add(22);
            List<Project> projectList = iProjectService.listByIds(list);
            for (Project project : projectList) {
                project.setCreateId(user.getUserId());
                project.setCreateTime(LocalDateTime.now());
                project.setCreateUser(user.getNickname());
            }
            save = iProjectService.saveBatch(projectList);
            if (!save){
                return ResultUtil.error(Constant.REGISTER_FAIL);
            }
            List<Apidetail> apidetailList = iApidetailService.list(new QueryWrapper<Apidetail>().lambda().eq(Apidetail::getProjectId, list));
            for (Apidetail apidetail : apidetailList) {
                apidetail.setCreateId(user.getUserId());
                apidetail.setCreateTime(LocalDateTime.now());
                apidetail.setCreateUser(user.getNickname());
            }
            save = iApidetailService.saveBatch(apidetailList);
            if (!save){
                return ResultUtil.error(Constant.REGISTER_FAIL);
            }
            List<Category> categoryList = iCategoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getProjectId, list));
            for (Category category : categoryList) {
                category.setCreateId(user.getUserId());
                category.setCreateTime(LocalDateTime.now());
                category.setCreateUser(user.getNickname());
            }
            save = iCategoryService.saveBatch(categoryList);
        return ResultUtil.flag(save);
    }

    @RequestMapping("/toFind")
    public ModelAndView toFind(){
        return new ModelAndView(thyme+"/user/find");
    }

    @RequestMapping("/sendEmail")
    public ResultUtil sendEmail(String email,String captchaCode){
        //判断验证码是否有效
        Session session = getSession();
        if (!session.getAttribute("captchaCode").equals(captchaCode)) {
            return ResultUtil.error("验证码错误或已过期！");
        }
        try {
            HttpServletRequest request = getRequest();
            String appUrl = request.getScheme() + "://" + request.getServerName();
            String context = "wwDoc系统密码重置地址："+appUrl+"/user/toReset?validate="+DigestUtils.md5(email);
            logger.debug("------context==="+context);
            iMailService.sendHtmlMail(email, "wwDoc—系统密码找回", context);
            return ResultUtil.success("邮件发送成功，请注意查收!");
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.debug("----/user/sendEmail------\n"+e.getMessage());
            return ResultUtil.error("邮件发送失败！");
        }
    }

    @RequestMapping("/toReset")
    public ModelAndView toReset(String validate){
        ModelAndView mv = new ModelAndView(thyme + "/user/reset");
        mv.addObject("valid", validate);
        return mv;
    }

    @RequestMapping("/resetPwd")
    public ResultUtil resetPwd(String password,String validate,String captchaCode){
        //判断验证码是否有效
        Session session = getSession();
        if (!session.getAttribute("captchaCode").equals(captchaCode)) {
            return ResultUtil.error("验证码错误或已过期！");
        }
        List<User> userList = iUserService.list();
        User users = null;
        for (User user : userList) {
            if (DigestUtils.md5(user.getEmail()).equals(validate)){
                users = user;
            }
        }
        if (users!=null) {
            users.setPassword(DigestUtils.md5(password));
            return ResultUtil.flag(iUserService.updateById(users));
        }else {
            return ResultUtil.error("密码重置失败，请检查邮箱设置！");
        }

    }

}
