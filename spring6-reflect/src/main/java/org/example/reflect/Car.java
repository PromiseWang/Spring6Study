package org.example.reflect;

/**
 * Author: Promise
 * Date: 2024-02-07 23:59
 * Description:
 */

public class Car {
    private String name;
    private int age;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car() {

    }

    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    private Car(String name) {
        this.name = name;
    }


    // 普通私有方法
    private void run() {
        System.out.println("run......");
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
