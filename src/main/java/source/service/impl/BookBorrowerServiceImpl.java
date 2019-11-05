package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Book_Borrower;
import source.repository.BookBorrowerRepository;
import source.service.BookBorrowerService;

import java.io.Serializable;

public class BookBorrowerServiceImpl implements BookBorrowerService {
    @Autowired
    private BookBorrowerRepository bookBorrowerRepository;

    @Override
    public Iterable<Book_Borrower> findAll() {
        return bookBorrowerRepository.findAll();
    }

    @Override
    public Book_Borrower findById(Serializable id) {
        return bookBorrowerRepository.findOne(id);
    }

    @Override
    public void save(Book_Borrower book_borrower) {
        bookBorrowerRepository.save(book_borrower);
    }

    @Override
    public void delete(Serializable id) {
        bookBorrowerRepository.delete(id);
    }

}
