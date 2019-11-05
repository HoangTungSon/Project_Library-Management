package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Book_Borrower;

import java.io.Serializable;

public interface BookBorrowerRepository extends PagingAndSortingRepository<Book_Borrower, Serializable> {
}
