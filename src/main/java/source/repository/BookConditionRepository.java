package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Book_condition;

public interface BookConditionRepository extends PagingAndSortingRepository<Book_condition, Long> {

    Iterable<Book_condition> findAllByStatusContaining(String status);
}
