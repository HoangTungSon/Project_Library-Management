package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.book.Book;
import source.repository.BookRepository;
import source.service.BookService;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> findAllByTitleContaining(String title) {
        return bookRepository.findAllByTitleContaining(title);
    }
}
