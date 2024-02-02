package org.example.spring6.iocxml.di;

/**
 * Author: Wang Xinran
 * Date: 2024-02-02 17:14
 * Description:
 */

public class Book {
    private String bookName;
    private String author;

    public Book() {
        System.out.println("无参构造已经被执行");
    }
    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
        System.out.println("有参构造已经被执行");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // 通过set方法注入
        Book book = new Book();
        book.setBookName("Java");
        book.setAuthor("zhangsan");

        // 通过构造器注入
        Book book1 = new Book("cpp", "lisi");
    }
}
