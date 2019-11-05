package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.borrower.Occupation;

public interface OccupationRepository extends PagingAndSortingRepository<Occupation, Long> {
}
