package org.example.spring6.iocxml.auto.dao.impl;

import org.example.spring6.iocxml.auto.dao.UserDao;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 16:33
 * Description:
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void addUserDao() {
        System.out.println("执行了UserDao方法");
    }
}
