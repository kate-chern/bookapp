package project.bokapp.repository;

import java.util.List;
import project.bokapp.model.Book;

public interface BookRepository {
    Book save(Book book);

    List findAll();
}
