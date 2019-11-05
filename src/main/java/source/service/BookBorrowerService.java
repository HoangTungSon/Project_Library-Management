package source.service;

import source.model.Book_Borrower;

import java.io.Serializable;

public interface BookBorrowerService {

    Iterable<Book_Borrower> findAll();

    Book_Borrower findById(Serializable id);

    void save (Book_Borrower book_borrower);

    void delete (Serializable id);

}
