package project.bokapp.repository;

import java.util.List;
import java.util.Optional;

import project.bokapp.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();

    Optional<Book> findById(Long id);
}
