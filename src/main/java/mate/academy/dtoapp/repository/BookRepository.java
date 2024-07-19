package mate.academy.dtoapp.repository;

import java.util.List;
import mate.academy.dtoapp.model.Book;

public interface BookRepository {
    List<Book> findAll();

    Book findById(Long id);

    Book createBook(Book book);
}
