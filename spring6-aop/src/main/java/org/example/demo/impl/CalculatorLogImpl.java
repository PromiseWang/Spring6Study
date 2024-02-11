package org.example.demo.impl;

import org.example.demo.Calculator;

/**
 * Author: Wang Xinran
 * Date: 2024-02-09 13:20
 * Description: 含有日志的实现类, 包含四则运算
 */

public class CalculatorLogImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        System.out.printf("[日志] add方法开始执行, 参数是:%d, %d", a, b);
        int result = a + b;
        System.out.println("方法内部result = " + result);
        System.out.printf("[日志] add方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.printf("[日志] sub方法开始执行, 参数是:%d, %d", a, b);
        int result = a - b;
        System.out.println("方法内部result = " + result);
        System.out.printf("[日志] sub方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.printf("[日志] mul方法开始执行, 参数是:%d, %d", a, b);
        int result = a * b;
        System.out.println("方法内部result = " + result);
        System.out.printf("[日志] mul方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.printf("[日志] div方法开始执行, 参数是:%d, %d", a, b);
        int result = a / b;
        System.out.println("方法内部result = " + result);
        System.out.printf("[日志] div方法执行结束, 结果是:%d", result);
        return result;
    }
}
