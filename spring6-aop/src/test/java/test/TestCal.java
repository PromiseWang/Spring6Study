package test;

import org.example.demo.Calculator;
import org.example.demo.impl.CalculatorImpl;
import org.example.demo.proxy.ProxyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Promise
 * Date: 2024-02-10 19:46
 * Description:
 */

public class TestCal {
    @Test
    public void testCalculator() {
        // 1. 创建代理对象(动态)
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
    }


    @Test
    public void testAOPAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        org.example.annotationaop.Calculator calculator = context.getBean(org.example.annotationaop.Calculator.class);
        System.out.println("**********add()开始执行**********");
        calculator.add(1, 2);
        System.out.println("**********add()执行完毕**********");
        System.out.println("**********div()开始执行**********");
        calculator.div(2, 0);
        System.out.println("**********div()执行完毕**********");
    }

    @Test
    public void testXMLAOPAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-aop.xml");
        org.example.xmlaop.Calculator calculator = context.getBean(org.example.xmlaop.Calculator.class);
        System.out.println("**********add()开始执行**********");
        calculator.add(6, 2);
        System.out.println("**********add()执行完毕**********");
        System.out.println("**********div()开始执行**********");
        calculator.div(4, 0);
        System.out.println("**********div()执行完毕**********");
    }
}
