package source.service;

import source.model.Book_condition;

public interface BookConditionService {

    Iterable<Book_condition> findAll();

    Book_condition findById(Long id);

    void save (Book_condition book_condition);

    void delete (Long id);

    Iterable<Book_condition> findAllByStatusContaining (String status);

}
