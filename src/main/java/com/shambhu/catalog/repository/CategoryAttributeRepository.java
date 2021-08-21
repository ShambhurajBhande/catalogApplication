package com.shambhu.catalog.repository;

import com.shambhu.catalog.model.Category;
import com.shambhu.catalog.model.CategoryAttributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryAttributeRepository extends CrudRepository<CategoryAttributes, Long> {
    List<CategoryAttributes> findByCategoryId(Long categoryId);
}
