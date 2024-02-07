package org.example.spring6.iocxml.auto.controller;

import org.example.spring6.iocxml.auto.service.UserService;
import org.example.spring6.iocxml.auto.service.impl.UserServiceImpl;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 16:31
 * Description:
 */

public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller方法执行");
        // 调用service方法
        userService.addUserService();
    }
}
