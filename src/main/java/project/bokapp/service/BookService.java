package project.bokapp.service;

import java.util.List;
import project.bokapp.model.Book;

public interface BookService {
    Book save(Book book);

    List findAll();
}
