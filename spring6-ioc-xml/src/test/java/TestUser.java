import org.example.spring6.iocxml.User;
import org.example.spring6.iocxml.bean.UserDao;
import org.example.spring6.iocxml.di.Book;
import org.example.spring6.iocxml.ditest.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 16:37
 * Description:
 */

public class TestUser {
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 1. 根据id获取bean
        User user1 = (User) context.getBean("user");
        System.out.println("根据id获取bean: " + user1);

        // 2. 根据类型获取bean
        User user2 = context.getBean(User.class);
        System.out.println("根据类型获取bean: " + user2);

        // 3. 根据id和类型获取bean
        User user3 = context.getBean("user", User.class);
        System.out.println("根据id和类型获取bean: " + user3);
    }

    @Test
    public void testUserDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 根据类型获取接口对应的bean
        UserDao userDao = context.getBean(UserDao.class);
        System.out.println(userDao);
        userDao.run();
    }

    @Test
    public void testSetter() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testConstructor() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("bookConstructor", Book.class);
        System.out.println(book);
    }

    @Test
    public void testEmployee() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-test.xml");
        // 员工对象
        Employee employee = context.getBean("employee", Employee.class);
        employee.work();
    }

    @Test
    public void testEmployee2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-test.xml");
        Employee employee = context.getBean("employee", Employee.class);
        employee.work();
    }
}
