package org.example.spring6.iocxml.auto.service.impl;

import org.example.spring6.iocxml.auto.dao.UserDao;
import org.example.spring6.iocxml.auto.dao.impl.UserDaoImpl;
import org.example.spring6.iocxml.auto.service.UserService;

/**
 * Author: Promise
 * Date: 2024-02-07 16:32
 * Description:
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("UserService()方法执行");
        userDao.addUserDao();
    }
}
