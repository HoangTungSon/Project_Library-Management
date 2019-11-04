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
}
