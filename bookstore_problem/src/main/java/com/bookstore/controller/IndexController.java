package com.starrockbooks.controller;

import com.starrockbooks.model.Book;
import com.starrockbooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    public IndexController() {

//        this.bookService = new BookServiceImpl();
    }

    /*
        VIEW DATABASE
     */

    @GetMapping("/")
    public String index(Model model) {

        List<Book> bookList = this.bookService.findAllBooks();
        model.addAttribute("books", bookList);
//        model.addAttribute("showTable", Boolean.FALSE);
        return "index";
    }

    @GetMapping("/search")
    public String searchPage()
    {
        return "search";
    }

    @PostMapping("/search")
    public String searchBook(Model model, @RequestParam("filter") String filter) {

        model.addAttribute("books", bookService.findAllFilteredBooks(filter));

        //Prevent non-admin to view all books
        if (!filter.equals("")) {
            return "view";
        }
        return "index";
    }

    /*
        VIEW ALL BOOKS
     */
    @GetMapping("/books/view")
    public String viewBooksPage(Model model) {
        List<Book> bookList = this.bookService.findAllBooks();
        model.addAttribute("books", bookList);
        return "view";
    }



    /*
        ADD BOOK
     */

    @GetMapping("/books/add")
    public String addBookPage(Model model) {
        return "addbook";
    }

    @PostMapping("/books/add")
    public String addBookFormSubmit(Model model, @RequestParam("bookName") String bookName
            , @RequestParam("bookAuthor") String bookAuthor, @RequestParam("bookPrice") String bookPrice, @RequestParam("bookISBN") String bookISBN, @RequestParam("bookGenre") String bookGenre, @RequestParam("bookDate") String bookDate) {

        Double bookPriceDouble = 0.0;
        Long bookISBNLong = 0L;
        if (bookName == null || bookName.isEmpty()) {
            model.addAttribute("errorMessage", "Book Name is required");
            return "addbook";
        } else if (bookISBN != null) {
            try {
                bookISBNLong = Long.valueOf(bookISBN);
            } catch (NumberFormatException nfex) {
                model.addAttribute("errorMessage", "Invalid ISBN");
                return "addbook";
            }
        }
        if (bookPrice != null) {
            try {
                bookPriceDouble = Double.valueOf(bookPrice);
            } catch (NumberFormatException nfex) {
                model.addAttribute("errorMessage", "Invalid book price");
                return "addbook";
            }
        }

        Book book = new Book(bookName, bookISBNLong, bookPriceDouble, bookAuthor , bookGenre, bookDate);
        book = bookService.addBook(book);
        model.addAttribute("success", Boolean.TRUE);
//        return "addbook";

        return "redirect:/books/view";
    }

    /*
        EDIT BOOK
     */
    @GetMapping(value = "/books/edit/{bookId}")
    public String editBookForm(@PathVariable Integer bookId, Model model) {

        Book book = bookService.findBookById(bookId);
        if (book != null) {
            model.addAttribute("bookName", book.getBookName());
            model.addAttribute("bookPrice", book.getPrice());
            model.addAttribute("bookAuthor", book.getAuthor());
            model.addAttribute("bookId", book.getBookId());
            model.addAttribute("bookISBN", book.getISBN());
            model.addAttribute("bookGenre", book.getGenre());
            model.addAttribute("bookDate", book.getDate());
            return "edit";
        } else {
            return "view";
        }
    }

    @PostMapping(value = "/books/edit")
    public String saveBookEdit(Model model, @RequestParam(value = "bookName") String
            bookName, @RequestParam(value = "bookPrice") String bookPrice, @RequestParam(value = "bookId") Integer bookId, @RequestParam(value = "bookAuthor") String bookAuthor,
                               @RequestParam(value = "bookISBN") String bookISBN, @RequestParam(value = "bookGenre") String bookGenre, @RequestParam(value = "bookDate") String bookDate) {

        Double bookPriceDouble;
        Long bookISBNLong;
        try{
            bookPriceDouble=Double.parseDouble(bookPrice);
            bookISBNLong=Long.parseLong(bookISBN);
        }
        catch(NumberFormatException e)
        {
            return "redirect:/books/view";
        }
        bookService.editBook(bookId, bookName, bookPrice, bookAuthor, bookISBN, bookGenre, bookDate);
        return "redirect:/books/view";
    }

    /*
        DELETE GAME
     */

    @GetMapping(value = "/books/delete/{bookId}")
    public String deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBookById(bookId);
        return "redirect:/books/view";
    }

}