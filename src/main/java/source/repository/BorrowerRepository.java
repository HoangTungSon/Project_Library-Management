package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Borrower;

public interface BorrowerRepository extends PagingAndSortingRepository<Borrower, Long> {

    Iterable<Borrower> findAllByOccupation_Type(String occupation_type);

    Borrower findAllByNationalId(Long nationalId);
}
