package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // 注解在属性上
@Retention(RetentionPolicy.RUNTIME)  // 运行时生效
public @interface Di {

}
