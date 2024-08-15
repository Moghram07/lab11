package com.example.lab11blog.Service;

import com.example.lab11blog.ApiException.ApiException;
import com.example.lab11blog.Repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import com.example.lab11blog.Model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public List<Comment> getAllComments() {
        return commentsRepository.findAll();
    }

    public void addComment(Comment comment) {
        commentsRepository.save(comment);
    }

    public void deleteComment(Integer id) {
        Comment c = commentsRepository.findByCommentId(id);
        if (c == null){
            throw new ApiException("Comment not found");
        }
        commentsRepository.delete(c);
    }

    public void updateComment(Integer id, Comment comment) {
        Comment c = commentsRepository.findByCommentId(id);
        if (c == null){
            throw new ApiException("Comment not found");
        }
        c.setPost(comment.getPost());
        c.setContent(comment.getContent());

        commentsRepository.save(c);
    }

    public List<Comment> getCommentsByUserId(int id) {
        return commentsRepository.findByUser_Id(id);
    }


}
