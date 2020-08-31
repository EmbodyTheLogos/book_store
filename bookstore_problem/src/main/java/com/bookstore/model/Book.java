package com.starrockbooks.model;

import javax.persistence.*;

@Entity
public class Book {

    //
    //  instance data

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 100)
    private Integer bookId;
    private String date;
    private String bookName;
    private Double price;

    private String author;
    private Long ISBN;
    private String genre;

    public Book() {
    }


    public Book(String bookName,Long ISBN, Double price, String author, String genre, String date) {
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.ISBN=ISBN;
        this.genre=genre;
        this.date=date;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
