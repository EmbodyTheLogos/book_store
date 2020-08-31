package com.starrockbooks.jpa;

import com.starrockbooks.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface JpaBookRepository extends CrudRepository<Book, Integer> {
}
