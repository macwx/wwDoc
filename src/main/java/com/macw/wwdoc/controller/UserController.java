package com.macw.wwdoc.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IUserService;
import com.macw.wwdoc.util.DigestUtils;
import com.macw.wwdoc.util.ResultUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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
public class UserController extends BaseControler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserService iUserService;

    @RequestMapping("/toRegister")
    public ModelAndView toRegister() {
        return new ModelAndView(thyme + "/user/register");
    }

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView(thyme + "/user/login");
    }

    @RequestMapping("/userLogin")
    public ResultUtil userLogin(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return ResultUtil.error(Constant.PARAM_FAIL);
        }
        //  1.将用户输入的账号密码 封装在token中
        password = DigestUtils.md5(password);
        logger.debug("password=== " +password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        2.获取Subject
        Subject subject = SecurityUtils.getSubject();
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
            return ResultUtil.ok(Constant.LOGIN_SUCCESS_MSG);
        } catch (Exception e) {
            // 有异常说明登录失败，
            logger.debug("登录失败  异常  " + e.getMessage());
            logger.debug("参数 loginName = " + username);
            logger.debug("参数 pwd = " + password);
            return ResultUtil.error(Constant.LOGIN_FAIL_MSG);
        }
    }


}
