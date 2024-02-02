package org.example.spring6.iocxml.bean;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 17:05
 * Description:
 */

public class PersonDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("Person......");
    }
}
