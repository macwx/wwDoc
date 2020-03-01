package com.macw.wwdoc.controller;

import com.macw.wwdoc.entity.User;
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
    //putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"key\":\"$(imageInfo.width)\",\"h\":\"$(imageInfo.height)\"}");

    @RequestMapping("/wwDoc")
    public ModelAndView wwDoc(){
        ModelAndView mv = new ModelAndView(thyme+"/index");
        User user = getUser();
        mv.addObject("user",user);
        return mv;
    }
}
