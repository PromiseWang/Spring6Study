package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)  // 注解可以用在类上或接口上
@Retention(RetentionPolicy.RUNTIME)  // 运行时生效
public @interface Bean {

}
