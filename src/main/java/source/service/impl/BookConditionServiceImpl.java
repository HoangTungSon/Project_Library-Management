package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Book_condition;
import source.repository.BookConditionRepository;
import source.service.BookConditionService;

public class BookConditionServiceImpl implements BookConditionService {

    @Autowired
    private BookConditionRepository bookConditionRepository;

    @Override
    public Iterable<Book_condition> findAll() {
        return bookConditionRepository.findAll();
    }

    @Override
    public Book_condition findById(Long id) {
        return bookConditionRepository.findOne(id);
    }

    @Override
    public void save(Book_condition book_condition) {
bookConditionRepository.save(book_condition);
    }

    @Override
    public void delete(Long id) {
bookConditionRepository.delete(id);
    }

    @Override
    public Iterable<Book_condition> findAllByStatusContaining(String status) {
        return bookConditionRepository.findAllByStatusContaining(status);
    }
}
