package org.example.demo.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Author: Wang Xinran
 * Date: 2024-02-10 19:29
 * Description:
 */

public class ProxyFactory {

    // 目标对象
    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 创建一个方法, 返回代理对象(动态)
    public Object getProxy() {
        /*
         * @param ClassLoader: 加载动态生成代理类的类加载器
         * @param interfaces: 目标对象实现所有接口类型的class
         * @param InvocationHandler: 设置代理对象实现目标对象方法的过程
         * */
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             * @param proxy 代理对象
             * @param method 需要重写目标对象的方法
             * @param args method方法中所需要的参数
             * @return Object
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 调用目标方法
                Object result = null;
                try {
                    System.out.println("[动态代理][日志] " + method.getName() + ", 参数: " + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[动态代理][日志] " + method.getName() + ", 结果: " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[动态代理][日志] " + method.getName() + ", 异常: " + e.getMessage());
                } finally {
                    System.out.println("[动态代理][日志] " + method.getName() + ", 方法执行完毕");
                }
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
