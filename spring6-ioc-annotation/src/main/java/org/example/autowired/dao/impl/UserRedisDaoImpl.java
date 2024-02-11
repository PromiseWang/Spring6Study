package org.example.autowired.dao.impl;

import org.example.autowired.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Author: Promise
 * Date: 2024-02-07 23:15
 * Description:
 */

@Repository
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("user redis......");
    }
}
