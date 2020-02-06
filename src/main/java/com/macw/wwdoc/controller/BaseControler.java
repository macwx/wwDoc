package com.macw.wwdoc.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Macw
 * @version 1.0
 * @date 2020/1/31 15:11
 */
@RestController
public class BaseControler {

    public String thyme = "views";


    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
    }


}
