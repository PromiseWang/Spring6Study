package org.example.autowired.controller;

import org.example.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: Promise
 * Date: 2024-02-07 20:38
 * Description:
 */

@Controller
public class UserController {
    // 注入service
    // 第一种方式: 属性注入
    // @Autowired  // 根据类型找到对应对象, 完成注入
    // private UserService userService;

    // 第二种方式: set注入
    // 生成setter()
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller......");
        userService.add();
    }
}
