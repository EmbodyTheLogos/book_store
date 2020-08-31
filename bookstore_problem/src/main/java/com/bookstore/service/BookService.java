package com.starrockbooks.service;

import com.starrockbooks.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBooks();

    Book addBook(Book book);

    List<Book> findAllFilteredBooks(String filter);

    Book findBookById(Integer bookId);

    Book editBook(Integer bookId, String bookName, String bookPrice, String bookAuthor, String bookISBN, String bookGenre, String bookDate);

    boolean deleteBookById(Integer bookId);
}
