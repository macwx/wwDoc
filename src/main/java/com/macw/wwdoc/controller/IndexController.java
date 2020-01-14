package com.macw.wwdoc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "doc/index";
    }

    @RequestMapping("/layuimini")
    public String layuimini(){
        return "views/index";
    }
}
