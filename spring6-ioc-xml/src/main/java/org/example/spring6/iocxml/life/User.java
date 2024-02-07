package org.example.spring6.iocxml.life;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 12:47
 * Description:
 */

public class User {
    private String name;

    public User() {
        System.out.println("第一步: 这是无参构造函数, 创建bean对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步: 给bean对象设置属性值");
    }

    // 初始化的方法
    public void initMethod() {
        System.out.println("第四步: bean对象初始化, 调用指定方法进行初始化");
    }

    // 销毁的方法
    public void destroyMethod() {
        System.out.println("第七步: bean对象销毁, 调用制定方法进行销毁");
    }


}
