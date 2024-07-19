package mate.academy.dtoapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.dtoapp.exception.EntityNotFoundException;
import mate.academy.dtoapp.exception.FailedToSaveDataException;
import mate.academy.dtoapp.mapper.BookMapper;
import mate.academy.dtoapp.model.Book;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookRepositoryImpl implements BookRepository {
    private final EntityManagerFactory entityManagerFactory;
    private final BookMapper bookMapper;

    @Override
    public List<Book> findAll() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("SELECT e FROM Book e", Book.class).getResultList();
        }
    }

    @Override
    public Book findById(Long id) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            return Optional.ofNullable(entityManager.find(Book.class, id))
                    .orElseThrow(
                            () -> new EntityNotFoundException("Book with id " + id + " not found")
                    );
        }
    }

    @Override
    public Book createBook(Book book) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(book);
            transaction.commit();
            return book;
        } catch (RuntimeException e) {
            throw new FailedToSaveDataException("Failed to create the book. Error: " + e);
        }
    }
}
