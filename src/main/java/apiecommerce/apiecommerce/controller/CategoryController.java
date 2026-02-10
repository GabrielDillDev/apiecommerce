package apiecommerce.apiecommerce.controller;

import apiecommerce.apiecommerce.model.Category;
import apiecommerce.apiecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        category.setId(id);
        return categoryService.save(category);
    }

    @PatchMapping("/{id}")
    public Category patch(@PathVariable Long id, @RequestBody Category category){
        return categoryService.patch(id, category); 
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    } 
}
