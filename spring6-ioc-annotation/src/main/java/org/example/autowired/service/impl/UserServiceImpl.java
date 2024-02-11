package org.example.autowired.service.impl;

import org.example.autowired.dao.UserDao;
import org.example.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 20:39
 * Description:
 */

@Service
public class UserServiceImpl implements UserService {
    // 注入dao
    // 第一种方式: 属性注入
    @Autowired
    @Qualifier (value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service.....");
        userDao.add();
    }
}
