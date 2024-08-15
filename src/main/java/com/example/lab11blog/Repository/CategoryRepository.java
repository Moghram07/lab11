package com.example.lab11blog.Repository;

import com.example.lab11blog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

        Category findByCategoryId(Integer id);
}
