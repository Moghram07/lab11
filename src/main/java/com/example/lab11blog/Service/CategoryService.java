package com.example.lab11blog.Service;

import com.example.lab11blog.ApiException.ApiException;
import com.example.lab11blog.Model.Category;
import com.example.lab11blog.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        Category c = categoryRepository.findByCategoryId(id);
        if (c == null){
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(c);
    }

    public void updateCategory(Integer id, Category category) {
        Category c = categoryRepository.findByCategoryId(id);
        if (c == null){
            throw new RuntimeException("Category not found");
        }
        c.setCategoryName(category.getCategoryName());

        categoryRepository.save(c);
    }
}
