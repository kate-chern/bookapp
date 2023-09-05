package project.bokapp.repository.book;

import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import project.bokapp.model.Book;
import project.bokapp.repository.SpecificationProvider;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "author";
    }

    public Specification<Book> getSpecification(String[] params) {
        return (root, query, criteriaBuilder) -> root.get("author")
                .in(Arrays.stream(params)
                        .toArray());
    }
}
