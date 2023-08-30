package project.bokapp.service;

import java.util.List;
import project.bokapp.dto.BookDto;
import project.bokapp.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    BookDto findById(Long id);

    List<BookDto> findAll();
}
