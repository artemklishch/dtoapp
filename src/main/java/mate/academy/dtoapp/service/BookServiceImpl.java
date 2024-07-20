package mate.academy.dtoapp.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dtoapp.dto.BookDto;
import mate.academy.dtoapp.dto.CreateBookRequestDto;
import mate.academy.dtoapp.mapper.BookMapper;
import mate.academy.dtoapp.model.Book;
import mate.academy.dtoapp.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .toList();
    }

    @Override
    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id);
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto createBook(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toBook(requestDto);
        return bookMapper.toBookDto(bookRepository.createBook(book));
    }
}
