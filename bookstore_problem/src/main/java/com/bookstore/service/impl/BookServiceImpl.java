package com.starrockbooks.service.impl;

import com.starrockbooks.model.Book;
import com.starrockbooks.repository.BookRepository;
import com.starrockbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl() {

//        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    @Override
    public Book addBook(Book book) {

//  NOT NEEDED FOR PS6
// if (book.getBookId() == null || book.getBookId() <= 0) {
//            book.setBookId(bookRepository.findNextBookId());
//        }
        return bookRepository.addBook(book);
    }

    @Override
    public List<Book> findAllFilteredBooks(String filter) {
        List<Book> books = bookRepository.findAllBooks();
        return books.stream()
                .filter(g -> g.getAuthor().toLowerCase().contains(filter.toLowerCase())|| g.getBookName().toLowerCase().contains(filter.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Book findBookById(Integer bookId) {
        return bookRepository.findBookById(bookId);
    }

    @Override
    public Book editBook(Integer bookId, String bookName, String bookPrice, String bookAuthor, String bookISBN, String bookGenre, String bookDate) {
        return bookRepository.editBook(bookId, bookName, bookPrice,bookAuthor,bookISBN,bookGenre,bookDate);
    }

    @Override
    public boolean deleteBookById(Integer bookId) {
        return bookRepository.deleteBookById(bookId);
    }
}
