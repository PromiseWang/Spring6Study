package org.example.bean;

import org.example.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Promise
 * Date: 2024-02-08 13:34
 * Description:
 */

public class AnnotationApplicationContext implements ApplicationContext {
    // 创建Map, 用于存放Bean的实例对象
    private static Map<Class, Object> beanFactory = new HashMap<>();

    private static String rootPath;

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 设置包扫描规则
    // 当前包及其子包, 若发现类前@Bean注解, 使用反射进行实例化
    // 创建有参数的构造, 设置扫描规则
    public AnnotationApplicationContext(String basePackage) {
        // 1. 将包名中的"."替换为"/", 形成路径
        String packagePath = basePackage.replaceAll("\\.", "/");

        // 2. 获取包的绝对路径(编译后)
        try {
            Enumeration<URL> paths = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (paths.hasMoreElements()) {
                URL url = paths.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                System.out.println(filePath);

                // 扫描包
                // 获取包前面路径部分, 字符串截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                loadBean(new File(rootPath));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 扫描包方法
    private static void loadBean(File file) throws Exception {
        // 1. 判断当前内容是否为文件夹
        if (file.isDirectory()) {
            // 2. 如果是文件夹, 获取里面所有内容
            File[] childrenFiles = file.listFiles();

            // 3. 判断 如果文件夹内为空, return; 否则遍历所有内容
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            // 3.1 遍历得到每个File对象, 继续向下递归判断
            for (File f : childrenFiles) {
                if (f.isDirectory()) {
                    loadBean(f);
                } else {
                    // 3.2 遍历得到File对象是文件, 判断有没有相关注解, 有则创建对象
                    // 3.3 得到包路径+类名称部分  字符串截取
                    String pathWithClass = f.getAbsolutePath().substring(rootPath.length() - 1);

                    // 3.4 判断当前文件类型是否为".class"
                    if (pathWithClass.contains(".class")) {
                        // 3.5 如果是.class类型, 将路径的"/"替换为"."    把".class"去掉
                        String allName = pathWithClass.replaceAll("/", ".").replace(".class", "");

                        // 3.6 判断类上是否有注解@Bean, 有则实例化
                        Class<?> clazz = Class.forName(allName);
                        if (!clazz.isInterface()) {  // 如果不是接口
                            // 3.6.1判断有没有注解
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                // 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                if (clazz.getInterfaces().length > 0) {  // 有接口
                                    beanFactory.put(clazz.getInterfaces())
                                }
                            }

                        }
                        // 3.7 把对象实例化之后, 放到容器map集合当中
                    }

                }
            }


        }

    }


}
