package project.bokapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import project.bokapp.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
}
