package project.bokapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.bokapp.cofig.MapperConfig;
import project.bokapp.dto.BookDto;
import project.bokapp.dto.CreateBookRequestDto;
import project.bokapp.model.Book;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    @Mapping(target = "id", ignore = true)
    Book toModel(CreateBookRequestDto createBookRequestDto);
}
