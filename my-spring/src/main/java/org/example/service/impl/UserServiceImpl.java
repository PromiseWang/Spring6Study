package org.example.service.impl;

import org.example.annotation.Bean;
import org.example.annotation.Di;
import org.example.dao.UserDao;
import org.example.service.UserService;

/**
 * Author: Promise
 * Date: 2024-02-08 13:17
 * Description:
 */

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

}
