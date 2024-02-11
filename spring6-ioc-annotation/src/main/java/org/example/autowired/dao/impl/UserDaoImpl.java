package org.example.autowired.dao.impl;

import org.example.autowired.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 20:39
 * Description:
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao......");
    }
}
