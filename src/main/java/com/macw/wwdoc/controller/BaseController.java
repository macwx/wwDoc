package com.macw.wwdoc.controller;

import com.macw.wwdoc.Constant;
import com.macw.wwdoc.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/1/31 15:11
 */
@RestController
public class BaseController {

    /**
     * 定义主题
     */
    public String thyme = "views";


    /**
     * 获取request请求
     *
     * @return request
     */
    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }

    /**
     * 获取response对象
     * @return response
     */
    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getResponse();
    }

    /**
     * 得到session对象
     *
     * @return session
     */
    public Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取项目id
     *
     * @return proId
     */
    public Integer getProId() {
        return (Integer) getSession().getAttribute(Constant.PRO_ID);
    }

    /**
     * 获取当前登录用户
     *
     * @return user
     */
    public User getUser() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getSession().getAttribute(Constant.LOGIN_USER);
        return user;
    }


}
