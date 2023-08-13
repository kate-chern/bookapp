package project.bokapp;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project.bokapp.model.Book;
import project.bokapp.service.BookService;

@SpringBootApplication
public class BokappApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BokappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setAuthor("Cronin A.J.");
                book.setTitle("The Citadel");
                book.setCoverImage("Image of Doctor with book");
                book.setIsbn("12345");
                book.setDescription("Story about doctor Andrew Manson how he discovered "
                        + "unpleasant facts about medicine");
                book.setPrice(BigDecimal.valueOf(47));

                Book secondBook = new Book();
                secondBook.setAuthor("Agatha Christie");
                secondBook.setTitle("A Murder is Announced");
                secondBook.setCoverImage("Image of room");
                secondBook.setIsbn("23456");
                secondBook.setDescription("Story about unannounced murder. "
                        + "Question is, there were really murder or just joke?");
                secondBook.setPrice(BigDecimal.valueOf(48));

                bookService.save(book);
                bookService.save(secondBook);

                System.out.println(bookService.findAll());
            }
        };
    }
}
