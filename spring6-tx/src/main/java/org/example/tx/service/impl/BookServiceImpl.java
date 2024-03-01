package org.example.tx.service.impl;

import org.example.tx.dao.BookDao;
import org.example.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Promise
 * Date: 2024-02-29 14:53
 * Description:
 */

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 1. 根据图书id查询图书价格
        Integer price = bookDao.getBookPriceByBookId(bookId);

        // 2. 更新图书表的库存量
        bookDao.updateStock(bookId);

        // 3. 更新用户表的用户余额
        bookDao.updateUserBalance(userId, price);

    }
}
