package com.starrockbooks.bootstrap;

import com.starrockbooks.model.ApplicationUser;
import com.starrockbooks.model.Book;
import com.starrockbooks.repository.ApplicationUserRepository;
import com.starrockbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader() {
//        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        /*
            Load the books!
         */
        String date1 = "2018-01-16";
        Book g1 = new Book( "12 Rules for Life",241351634L, 15.39, "Jordan Peterson","Self Help",date1);
        this.bookRepository.addBook(g1);

        String date2 = "1999-03-26";
        Book g2 = new Book( "Maps of Meaning: The Architecture of Belief",415922224L, 31.98, "Jordan Peterson","Psychology",date2);
        this.bookRepository.addBook(g2);

        String date3 = "2006-06-01";
        Book g3 = new Book("Man's search for meaning",9780807014295L, 9.89, "Viktor E. Frankl","Autobiography",date3);
        this.bookRepository.addBook(g3);

        String date4 = "2001-08-22";
        Book g4 = new Book("Crime and Punishment",486415872L, 7.0, "Fyodor Dostoyevsky","Psychological Fiction",date4);
        this.bookRepository.addBook(g4);

        String date5 = "1955-08-04";
        Book g5 = new Book("Modern Man in Search of a Soul",9780156612067L, 12.52, "Carl Jung","Psychology",date5);
        this.bookRepository.addBook(g5);

        String date6 = "2015-05-11";
        Book g6 = new Book("Absolute Java 6th Edition",134041674L, 170.81, "Walter Savitch","Programming",date6);
        this.bookRepository.addBook(g6);

        String date7 = "1851-10-18";
        Book g7 = new Book("Moby Dick",9780486432151L, 4.99, "Herman Melville","Novel", date7);
        this.bookRepository.addBook(g7);



        /*
            Make some users
         */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("123456"), Boolean.TRUE);
        applicationUserRepository.addUser(user1);

    }
}
