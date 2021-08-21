package com.shambhu.catalog.service.impl;

import com.shambhu.catalog.model.Category;
import com.shambhu.catalog.model.CategoryAttributes;
import com.shambhu.catalog.model.Product;
import com.shambhu.catalog.repository.CategoryAttributeRepository;
import com.shambhu.catalog.repository.CategoryRepository;
import com.shambhu.catalog.repository.ProductRepository;
import com.shambhu.catalog.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class CatalogServiceImpl implements CatalogService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryAttributeRepository categoryAttributeRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Category saveCategory(final Category category) {
        Category categorySaved= categoryRepository.save(category);
        LOGGER.info("Saved category {}",category);

        return categorySaved;
    }

    @Override
    public Product saveProduct(final Product product) {
        Product productSaved= productRepository.save(product);
        LOGGER.info("Saved product {}",product);

        return productSaved;
    }

    @Override
    public List<CategoryAttributes> saveCategoryAttributes(Long categoryId,final List<CategoryAttributes> categoryAttributes) throws Exception {
        return categoryRepository.findById(categoryId).map(category -> {
            categoryAttributes.forEach((ca)->{
                ca.setCategory(category);
                categoryAttributeRepository.save(ca);
            });
            return categoryAttributes;
        }).orElseThrow(() -> new Exception("Category " + categoryId + " not found"));

    }

    @Override
    public List<CategoryAttributes> getCategoryAttributes(final Long categoryId) {
        return categoryAttributeRepository.findByCategoryId(categoryId);
    }

    @Override
    public Product getProduct(final Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        return  product.isPresent()? product.get(): null;
    }
}
