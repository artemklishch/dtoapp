package mate.academy.dtoapp.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.dtoapp.model.Book;

public interface BookRepository {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Book createBook(Book book);
}
