package com.example.lab11blog.Repository;

import com.example.lab11blog.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    Comment findByCommentId(Integer commentId);

    List<Comment> findByUser_Id(Integer userId);


}
