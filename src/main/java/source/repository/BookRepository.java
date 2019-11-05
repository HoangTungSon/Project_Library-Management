package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.book.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Iterable<Book> findAllByTitleContaining(String title);
}
