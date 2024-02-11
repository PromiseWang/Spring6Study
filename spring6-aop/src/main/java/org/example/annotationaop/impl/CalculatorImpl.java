package org.example.annotationaop.impl;


import org.example.annotationaop.Calculator;
import org.springframework.stereotype.Component;

/**
 * Author: Wang Xinran
 * Date: 2024-02-09 13:12
 * Description: 基本的实现类, 实现四则运算
 */

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        int result = a + b;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        int result = a - b;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        int result = a * b;
        System.out.println("方法内部result = " + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        int result = a / b;
        System.out.println("方法内部result = " + result);
        return result;
    }
}
