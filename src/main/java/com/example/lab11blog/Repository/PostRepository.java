package com.example.lab11blog.Repository;

import com.example.lab11blog.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Post findByPostId(Integer postId);

    List<Post> findByUser_Id(Integer userId);

    List<Post> findByTitle(String title);

    List<Post> findByPublishDateBefore(Date date);

    @Query("select p from Post p where p.category.categoryId = ?1")
    List<Post> findAllByCategoryId(Integer categoryId);

}
