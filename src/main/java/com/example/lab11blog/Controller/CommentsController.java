package com.example.lab11blog.Controller;

import com.example.lab11blog.Model.Comment;
import com.example.lab11blog.Service.CommentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {

    private final CommentsService commentsService;

    @GetMapping("/get")
    public ResponseEntity getComments() {
        return ResponseEntity.ok(commentsService.getAllComments());
    }

    @PostMapping("/add")
    public ResponseEntity addComment(@RequestBody @Valid Comment comment, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentsService.addComment(comment);
        return ResponseEntity.status(200).body("comment added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateComment(@PathVariable Integer id, @RequestBody @Valid Comment comment, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        commentsService.updateComment(id, comment);
        return ResponseEntity.status(200).body("comment updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteComment(@PathVariable Integer id) {
        commentsService.deleteComment(id);
        return ResponseEntity.status(200).body("comment deleted");
    }

    @GetMapping("/searchUser/{userId}")
    public ResponseEntity getCommentsByUserId(@PathVariable int id) {
        return ResponseEntity.ok(commentsService.getCommentsByUserId(id));
    }

}
