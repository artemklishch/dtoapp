package mate.academy.dtoapp.mapper;

import mate.academy.dtoapp.config.MapperConfig;
import mate.academy.dtoapp.dto.BookDto;
import mate.academy.dtoapp.dto.CreateBookRequestDto;
import mate.academy.dtoapp.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toBookDto(Book book);

    Book toBook(CreateBookRequestDto requestDto);
}
