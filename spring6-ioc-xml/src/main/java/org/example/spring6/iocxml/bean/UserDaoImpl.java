package org.example.spring6.iocxml.bean;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 17:01
 * Description:
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("run......");
    }
}
