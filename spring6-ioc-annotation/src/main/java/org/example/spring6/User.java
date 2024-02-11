package org.example.spring6;

import org.springframework.stereotype.Component;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 20:14
 * Description:
 */

@Component(value = "user")  // <bean id="user" class="......包名">, 值可以不写, 默认为类名首字母小写
public class User {

}
