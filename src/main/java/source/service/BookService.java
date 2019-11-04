package source.service;

import source.model.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findById(Long id);

    void save (Book book);

    void delete (Long id);

    Iterable<Book> findAllByTitleContaining (String title);
}
