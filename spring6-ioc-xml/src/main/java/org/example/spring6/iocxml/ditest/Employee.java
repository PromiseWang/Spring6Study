package org.example.spring6.iocxml.ditest;

import java.util.Arrays;

/**
 * Author: Promise
 * Date: 2024-02-02 18:01
 * Description:
 */

public class Employee {
    private String eName;

    private Integer age;

    // 员工输入某个部门
    private Department department;

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    // 爱好
    private String[] hobbies;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee() {

    }

    public Employee(String eName, Integer age, Department department) {
        this.eName = eName;
        this.age = age;
        this.department = department;
    }

    public void work() {
        System.out.println(eName + "员工在工作, 工龄为: " + age);
        department.info();
        System.out.println(Arrays.toString(hobbies));
    }
}
