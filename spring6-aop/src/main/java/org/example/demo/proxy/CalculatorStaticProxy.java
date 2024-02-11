package org.example.demo.proxy;

import org.example.demo.Calculator;

import java.lang.ref.PhantomReference;

/**
 * Author: Promise
 * Date: 2024-02-10 19:13
 * Description:
 */

public class CalculatorStaticProxy implements Calculator {

    // 被代理的目标对象传递过来
    private Calculator calculator;
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }


    @Override
    public int add(int a, int b) {
        // 输出日志
        System.out.printf("[日志] add方法开始执行, 参数是:%d, %d", a, b);

        // 调用目标对象的方法实现核心业务
        int result = calculator.add(a, b);

        // 输出日志
        System.out.printf("[日志] add方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        // 输出日志
        System.out.printf("[日志] sub方法开始执行, 参数是:%d, %d", a, b);

        // 调用目标对象的方法实现核心业务
        int result = calculator.sub(a, b);

        // 输出日志
        System.out.printf("[日志] sub方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        // 输出日志
        System.out.printf("[日志] mul方法开始执行, 参数是:%d, %d", a, b);

        // 调用目标对象的方法实现核心业务
        int result = calculator.mul(a, b);

        // 输出日志
        System.out.printf("[日志] mul方法执行结束, 结果是:%d", result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        // 输出日志
        System.out.printf("[日志] div方法开始执行, 参数是:%d, %d", a, b);

        // 调用目标对象的方法实现核心业务
        int result = calculator.div(a, b);

        // 输出日志
        System.out.printf("[日志] div方法执行结束, 结果是:%d", result);
        return result;
    }
}
