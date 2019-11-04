package source.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import source.model.Category;
import source.repository.CategoryRepository;
import source.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }
}
