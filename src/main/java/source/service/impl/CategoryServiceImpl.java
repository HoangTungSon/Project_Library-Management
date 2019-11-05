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

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
categoryRepository.delete(id);
    }

    @Override
    public Iterable<Category> findAllByTypeContaining(String type) {
        return categoryRepository.findAllByTypeContaining(type);
    }
}
