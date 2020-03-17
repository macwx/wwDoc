package com.macw.wwdoc.controller;

import com.macw.wwdoc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
public class IndexController  extends BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/","/index",""})
    public ModelAndView index(){
//        return "doc/index";
//        return new ModelAndView(thyme + "/user/login");
        return new ModelAndView( "html/index");
    }

    @RequestMapping("/wwDoc")
    public ModelAndView wwDoc(){
        ModelAndView mv = new ModelAndView(thyme+"/index");
        User user = getUser();
        mv.addObject("user",user);
        return mv;
    }

    @RequestMapping("/index/about")
    public ModelAndView toAbout(){
        return new ModelAndView("html/about");
    }

    @RequestMapping("/404")
    public ModelAndView toNull(){
        return new ModelAndView(thyme+"/404");
    }



}
