package org.example.tx.dao;

/**
 * Author: Promise
 * Date: 2024-02-29 14:53
 * Description:
 */

public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}
