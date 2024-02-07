package org.example.spring6.iocxml.factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 16:18
 * Description:
 */

public class MyFactoryBean implements FactoryBean<User1> {

    @Override
    public User1 getObject() throws Exception {
        return new User1();
    }

    @Override
    public Class<?> getObjectType() {
        return User1.class;
    }
}
