package apiecommerce.apiecommerce.service;

import apiecommerce.apiecommerce.model.Product;
import apiecommerce.apiecommerce.model.Category;
import apiecommerce.apiecommerce.repository.ProductRepository;
import apiecommerce.apiecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }    

    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Product patch(Long id, Product data){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (data.getName() != null){
            product.setName(data.getName());
        }

        if(data.getDescription() != null){
            product.setDescription(data.getDescription());
        }

        if(data.getPrice() != null){
            product.setPrice(data.getPrice());
        }

        if (data.getCategory() != null && data.getCategory().getId() != null){
            Category category = categoryRepository.findById(data.getCategory().getId()).
            orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

            product.setCategory(category);
        } 

        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
