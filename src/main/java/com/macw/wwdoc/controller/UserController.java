package com.macw.wwdoc.controller;


import com.macw.wwdoc.entity.User;
import com.macw.wwdoc.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Macw
 * @since 2020-01-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService iUserService;

    @RequestMapping("/test")
    public void test(){
        List<User> list = iUserService.list();
        System.out.println(list);
    }

}
