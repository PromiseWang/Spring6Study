package org.example.spring6.iocxml.ditest;

import java.util.List;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 18:01
 * Description:
 */

public class Department {
    private String dName;

    // 一个部门中有很多员工
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

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
        for (Employee emp : employeeList) {
            System.out.println(emp.geteName());
        }
    }
}
