import com.alibaba.druid.pool.DruidDataSource;
import org.example.spring6.iocxml.User;
import org.example.spring6.iocxml.auto.controller.UserController;
import org.example.spring6.iocxml.bean.UserDao;
import org.example.spring6.iocxml.di.Book;
import org.example.spring6.iocxml.dimap.Student;
import org.example.spring6.iocxml.ditest.Department;
import org.example.spring6.iocxml.ditest.Employee;
import org.example.spring6.iocxml.factoryBean.User1;
import org.example.spring6.iocxml.scope.Orders;
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

    @Test
    public void testArray() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-array.xml");
        Employee employee = context.getBean("employee", Employee.class);
        employee.work();
    }

    @Test
    public void testList() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-list.xml");
        Department department = context.getBean("department", Department.class);
        department.info();
    }

    @Test
    public void testMap() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-map.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

    @Test
    public void testRef() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-ref.xml");
        Student student = context.getBean("student", Student.class);
        student.run();
    }

    @Test
    public void testPLabel() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-ref.xml");
        Student student = context.getBean("studentP", Student.class);
        student.run();
    }

    @Test
    public void testJdbc() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("11111111");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    @Test
    public void testJdbc2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource = context.getBean(DruidDataSource.class);
        System.out.println(druidDataSource.getUrl());
    }

    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        Orders orders1 = context.getBean("orders", Orders.class);
        System.out.println(orders1);
    }

    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        org.example.spring6.iocxml.life.User user = context.getBean("user", org.example.spring6.iocxml.life.User.class);
        System.out.println(user);
        System.out.println("第六步: bean对象创建完成");
        context.close();  // 对象销毁  只有实现类才有这个函数, ApplicationContext并没有这个方法
    }

    @Test
    public void testFactoryBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-factorybean.xml");
        User1 user1 = context.getBean("user1", User1.class);
        System.out.println(user1);
    }

    @Test
    public void testController() {
        UserController controller = new UserController();
        controller.addUser();
    }

    @Test
    public void testAuto() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.addUser();
    }
}
