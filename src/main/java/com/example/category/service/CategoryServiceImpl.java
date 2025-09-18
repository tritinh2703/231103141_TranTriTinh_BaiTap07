package com.example.category.service;

import com.example.category.entity.Category;
import com.example.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repo;

    @Override
    public Page<Category> listAll(String keyword, Pageable pageable) {
        if (keyword != null && !keyword.isEmpty()) {
            return repo.findByNameContaining(keyword, pageable);
        }
        return repo.findAll(pageable);
    }

    @Override
    public Category get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        repo.save(category);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
