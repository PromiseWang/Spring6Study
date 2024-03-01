import org.example.tx.config.SpringConfig;
import org.example.tx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Author: Promise
 * Date: 2024-02-29 15:13
 * Description:
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(3, 1);
    }

    @Test
    public void testBuyBookLists() {
        Integer[] bookLists = {2, 2, 2, 2};
        bookController.checkout(bookLists, 1);
    }

    @Test
    public void testAnno() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController controller = context.getBean("bookController", BookController.class);
        controller.buyBook(1, 1);
    }
}
