package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.book.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    Iterable<Category> findAllByTypeContaining(String type);
}
