package com.starrockbooks.repository;

import com.starrockbooks.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks();

    Book addBook(Book book);

    Book findBookById(Integer bookId);

    Book editBook(Integer bookId, String bookName, String bookPrice, String bookAuthor, String bookISBN, String bookGenre, String bookDate);

    boolean deleteBookById(Integer bookId);
}
