package project.bokapp.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.bokapp.dto.BookDto;
import project.bokapp.dto.CreateBookRequestDto;
import project.bokapp.exception.EntityNotFoundException;
import project.bokapp.mapper.BookMapper;
import project.bokapp.model.Book;
import project.bokapp.repository.BookRepository;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        book.setIsbn("abc " + new Random().nextInt(1000));
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find book by id" + id));
        return bookMapper.toDto(book);
    }
}
