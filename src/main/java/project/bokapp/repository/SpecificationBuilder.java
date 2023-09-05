package project.bokapp.repository;

import org.springframework.data.jpa.domain.Specification;
import project.bokapp.dto.BookSearchParametersDto;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParametersDto bookSearchParametersDto);
}

