package com.starrockbooks.repository.impl;

import com.google.common.collect.MoreCollectors;
import com.starrockbooks.jpa.JpaBookRepository;
import com.starrockbooks.model.Book;
import com.starrockbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

//    PS5
//  private List<Book> bookList = new ArrayList<>();

    //  PS6
    @Autowired
    private JpaBookRepository jpaBookRepository;

    @Override
    public List<Book> findAllBooks() {
        // PS6
        return (List<Book>) jpaBookRepository.findAll();
    }
    //


    @Override
    public Book addBook(Book book) {
//        PS5
//        bookList.add(book);
//        return book;
        // PS6
        return jpaBookRepository.save(book);
    }

//  NOT NEEDED FOR PS6
// @Override
//    public Integer findNextBookId() {
//        Integer maxValue = 0;
//        for (Book book : bookList) {
//            if (book.getBookId() != null && book.getBookId() > maxValue) {
//                maxValue = book.getBookId();
//            }
//        }
//        return maxValue + 1;
//    }

    @Override
    public Book findBookById(Integer bookId) {
//        for (Book g : bookList) {
//            if (g.getBookId() == bookId) {
//                return g;
//            }
//        }
//        return null;
        //PS5
//        return bookList.stream().filter(g -> g.getBookId().equals(bookId)).collect(MoreCollectors.onlyElement());
        //
        //  PS6
        Optional<Book> bookOptional = jpaBookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        return null;
    }

    @Override
    public Book editBook(Integer bookId, String bookName, String bookPrice, String bookAuthor, String bookISBN, String bookGenre, String bookDate) {
        Book foundBook = findBookById(bookId);
        if (foundBook != null) {
            foundBook.setBookName(bookName);
            foundBook.setPrice(Double.parseDouble(bookPrice));
            foundBook.setAuthor(bookAuthor);
            foundBook.setISBN(Long.parseLong(bookISBN));
            foundBook.setGenre(bookGenre);
            foundBook.setDate(bookDate);
        }
// PS5
// return foundBook;

        // PS6
        if (foundBook == null) {
            return null;
        }
        return jpaBookRepository.save(foundBook);
    }

    @Override
    public boolean deleteBookById(Integer bookId) {
        Book foundBook = findBookById(bookId);
//  PS5
// if (foundBook != null) {
//            return bookList.remove(foundBook);
//        }
//        return false;
        // PS6
        if (foundBook != null) {
//            jpaBookRepository.delete(foundGame);
            jpaBookRepository.deleteById(foundBook.getBookId());
            return true;
        }
        return false;
    }
}
