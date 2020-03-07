package com.macw.wwdoc.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.Log;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.ILogService;
import com.macw.wwdoc.service.IUserService;
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
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

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

    @RequestMapping("/toRegister")
    public ModelAndView toRegister() {
        return new ModelAndView(thyme + "/user/register");
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView(thyme + "/user/login");
    }

    @RequestMapping("/userLogin")
    public ResultUtil userLogin(String username, String password,String captchaCode) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResultUtil.error(Constant.PARAM_FAIL);
        }
        //判断验证码是否有限
        Session session = getSession();
        if (!session.getAttribute("captchaCode").equals(captchaCode)){
            //
//            return ResultUtil.error("验证码错误或已过期！");
        }
        //清除session中的验证码
        session.removeAttribute("captchaCode");
        //  1.将用户输入的账号密码 封装在token中
        password = DigestUtils.md5(password);
        logger.debug("password=== " +password);
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

    @com.macw.wwdoc.config.Log(value = "退出登录",type = "exit")
    @RequestMapping("/loginLou")
    public ResultUtil loginLou(){
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
        session.setAttribute("captchaCode",captcha.getCode());
        //图片输出 响应流
        ServletOutputStream outputStream = response.getOutputStream();
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write(outputStream);
        //释放资源
        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome(){
        return new ModelAndView(thyme+"/welcome");
    }

}
