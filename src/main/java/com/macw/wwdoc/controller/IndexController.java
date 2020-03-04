package com.macw.wwdoc.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.macw.wwdoc.entity.User;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Console;
import java.io.IOException;

/**
 * @author 马超伟
 * @PROJECT_NAME: wwdoc
 * @Description:
 * @date 15:49
 * @Copyright: All rights Reserved, Designed By Huerdai  
 * Copyright:    Copyright(C) 2019-2020
 * Company       Huerdai Henan LTD.
 */
@Controller
public class IndexController  extends BaseControler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/","/index",""})
    public ModelAndView index(){
//        return "doc/index";
        return new ModelAndView(thyme + "/user/login");
    }

    @RequestMapping("/wwDoc")
    public ModelAndView wwDoc(){
        ModelAndView mv = new ModelAndView(thyme+"/index");
        User user = getUser();
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/404")
    public ModelAndView toNull(){
        return new ModelAndView(thyme+"/404");
    }



}
