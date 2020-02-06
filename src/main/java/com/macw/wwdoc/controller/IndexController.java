package com.macw.wwdoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class IndexController  extends BaseControler {

    @RequestMapping({"/","/index",""})
    public ModelAndView index(){
//        return "doc/index";
        return new ModelAndView(thyme + "/user/login");
    }

    @RequestMapping("/layuimini")
    public ModelAndView layuimini(){
        return new ModelAndView("views/index");
    }
}
