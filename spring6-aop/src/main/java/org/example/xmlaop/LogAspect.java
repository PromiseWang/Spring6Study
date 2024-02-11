package org.example.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Author: Promise
 * Date: 2024-02-10 23:14
 * Description:
 */

// 切面类
@Component
public class LogAspect {
    // 前置通知
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知, 方法名称: " + methodName + ", 参数为: " + Arrays.toString(args));
    }

    // 后置通知
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 后置通知, 方法名称: " + methodName);
    }

    // 返回通知
    public void afterReturningMethod(JoinPoint joinPoint, Object results) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知, 方法名称: " + methodName + ", 返回结果: " + results);
    }

    // 异常通知
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 异常通知, 方法名称: " + methodName + ", 异常结果: " + ex);
    }

    // 环绕通知
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {  // 使用ProceedingJoinPoint类型, 更强
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知, 目标方法之前执行");
            result = joinPoint.proceed();
            System.out.println("环绕通知, 目标方法返回值之后执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知, 目标方法出现异常时执行");
        } finally {
            System.out.println("环绕通知, 目标方法执行完毕时执行");
        }
        return result;
    }


    public void pointCut() {

    }
}

