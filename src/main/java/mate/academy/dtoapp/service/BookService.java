package mate.academy.dtoapp.service;

import java.util.List;
import mate.academy.dtoapp.dto.BookDto;
import mate.academy.dtoapp.dto.CreateBookRequestDto;

public interface BookService {
    List<BookDto> getAll();

    BookDto getById(Long id);

    BookDto createBook(CreateBookRequestDto book);
}
