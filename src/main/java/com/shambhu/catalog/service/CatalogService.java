package com.shambhu.catalog.service;

import com.shambhu.catalog.model.Category;
import com.shambhu.catalog.model.CategoryAttributes;
import com.shambhu.catalog.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface CatalogService {
    public Category saveCategory(Category category);
    public Product saveProduct(Product product);
    public List<CategoryAttributes> saveCategoryAttributes(Long categoryId,
                                                     List<CategoryAttributes> categoryAttributes) throws Exception;

    List<CategoryAttributes> getCategoryAttributes(Long categoryId);

    Product getProduct(Long productId);
}
