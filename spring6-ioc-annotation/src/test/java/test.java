import org.example.autowired.controller.UserController;
import org.example.config.SpringConfig;
import org.example.spring6.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 20:29
 * Description:
 */

public class test {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

    @Test
    public void testAutowired() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }

    @Test
    public void testUserControllerAnno() {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
