package org.example.tx.controller;

import org.example.tx.service.BookService;
import org.example.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: Promise
 * Date: 2024-02-29 14:51
 * Description:
 */

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;
    /**
     * 购买书的方法
     * @param bookId 图书id
     * @param userId 用户id
     * */
    public void buyBook(Integer bookId, Integer userId) {
        // 调用Service方法
        bookService.buyBook(bookId, userId);
    }

    public void checkout(Integer[] bookIds, Integer userId) {
        checkoutService.checkout(bookIds, userId);
    }
}
