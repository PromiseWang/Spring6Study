package org.example.spring6.iocxml.ditest;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 18:01
 * Description:
 */

public class Department {
    private String dName;

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public Department() {

    }

    public Department(String dName) {
        this.dName = dName;
    }

    public void info() {
        System.out.println("部门名称: " + dName);
    }
}
