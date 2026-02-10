package apiecommerce.apiecommerce.service;

import apiecommerce.apiecommerce.model.Category;
import apiecommerce.apiecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category patch(Long id, Category data){
        Category category = categoryRepository.findById(id).
        orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        if(data.getName() != null){
            category.setName(data.getName());
        }

        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
