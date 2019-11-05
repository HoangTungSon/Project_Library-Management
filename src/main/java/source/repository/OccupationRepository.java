package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Occupation;

public interface OccupationRepository extends PagingAndSortingRepository<Occupation, Long> {
}
