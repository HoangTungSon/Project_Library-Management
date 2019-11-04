package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
