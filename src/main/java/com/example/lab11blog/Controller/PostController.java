package com.example.lab11blog.Controller;

import com.example.lab11blog.Model.Post;
import com.example.lab11blog.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity getPosts(){
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.addPost(post);
        return ResponseEntity.status(200).body("post added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@PathVariable Integer id, @RequestBody @Valid Post post, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        postService.updatePost(id, post);
        return ResponseEntity.status(200).body("post updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postService.deletePost(id);
        return ResponseEntity.status(200).body("post deleted");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity findByUserId(@PathVariable int id) {
        return ResponseEntity.ok(postService.findByUserId(id));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(postService.findByTitle(title));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity findAllByCategoryId(@PathVariable int id) {
        return ResponseEntity.ok(postService.findAllByCategoryId(id));
    }

    @GetMapping("/before/{date}")
    public ResponseEntity findByPublishDateBefore(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return ResponseEntity.ok(postService.findByPublishDateBefore(date));
    }
}
