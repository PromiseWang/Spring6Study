import org.junit.jupiter.api.Test;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 16:00
 * Description:
 */


import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {
    // 创建Logger对象
    private Logger logger = LoggerFactory.getLogger(TestUserService.class);

    @Test
    public void testUserService() {
        // 加载Spring配置文件, 对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 获取创建的对象
        // context.getBean("userService")的返回值为Object类型, 需要强制类型转换
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService);

        // 使用对象调用方法进行调试
        userService.add();

        //手动写日志
        logger.info("执行调用成功**************");
    }

}

