package org.example.annotationaop;

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
@Aspect  // 切面类注解
@Component  // 在Spring IoC容器中管理
public class LogAspect {
    // 设置切入点和通知类型
    // 括号内写 切入点表达式 execution(访问修饰符 增强方法返回类型 增强方法所在类的全类名.方法名称(参数))
    // * 可以省略一些
    // 通知类型:
    //      前置 @Before()
    //      返回 @AfterReturning()
    //      异常 @AfterThrowing()
    //          目标方法出现异常, 这个通知会执行, 也能获取到目标方法异常信息
    //      后置 @After()
    //      环绕 @Around()

    // 前置通知 @Before()
    @Before(value = "execution(public int org.example.annotationaop.impl.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger --> 前置通知, 方法名称: " + methodName + ", 参数为: " + Arrays.toString(args));
    }

    // 后置通知 @After()
    @After(value = "execution (* org.example.annotationaop.impl.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 后置通知, 方法名称: " + methodName);
    }

    // 返回通知 @AfterReturning
    // 参数returning = "参数名", 下方函数参数中Object 命名也必须一致
    @AfterReturning(value = "execution(* org.example.annotationaop.impl.CalculatorImpl.*(..))", returning = "results")
    public void afterReturningMethod(JoinPoint joinPoint, Object results) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 返回通知, 方法名称: " + methodName + ", 返回结果: " + results);
    }

    // 异常通知 @AfterThrowing
    @AfterThrowing(value = "execution(* org.example.annotationaop.impl.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger --> 异常通知, 方法名称: " + methodName + ", 异常结果: " + ex);
    }

    // 环绕通知 @Around
    @Around(value = "execution(* org.example.annotationaop.impl.CalculatorImpl.*(..))")
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

    // 重用切入点表达式
    @Pointcut(value = "execution(* org.example.annotationaop.impl.CalculatorImpl.*(..))")
    public void pointCut() {

    }
}

