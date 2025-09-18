package com.example.category.service;

import com.example.category.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<Category> listAll(String keyword, Pageable pageable);
    Category get(Long id);
    void save(Category category);
    void delete(Long id);
}
