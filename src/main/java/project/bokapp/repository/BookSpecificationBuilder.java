package project.bokapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import project.bokapp.dto.BookSearchParametersDto;
import project.bokapp.model.Book;

@AllArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto bookSearchParametersDto) {
        Specification<Book> spec = Specification.where(null);
        if (bookSearchParametersDto.getTitles() != null
                && bookSearchParametersDto.getTitles().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("title")
                    .getSpecification(bookSearchParametersDto.getTitles()));
        }
        if (bookSearchParametersDto.getAuthors() != null
                && bookSearchParametersDto.getAuthors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager.getSpecificationProvider("author")
                    .getSpecification(bookSearchParametersDto.getAuthors()));
        }
        return spec;
    }
}
