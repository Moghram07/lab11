package com.example.lab11blog.Service;

import com.example.lab11blog.ApiException.ApiException;
import com.example.lab11blog.Model.Post;
import com.example.lab11blog.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void addPost(Post post){
        postRepository.save(post);
    }

    public void deletePost(Integer id){
        Post post = postRepository.findByPostId(id);
        if (post == null){
            throw new ApiException("post not found");
        }
        postRepository.delete(post);
    }

    public void updatePost(Integer id, Post post){
        Post p = postRepository.findByPostId(id);
        if (p == null){
            throw new ApiException("post not found");
        }
        p.setTitle(post.getTitle());
        p.setContent(post.getContent());
        p.setPublishDate(post.getPublishDate());

        postRepository.save(p);
    }

    public List<Post> findByUserId(int id) {
        return postRepository.findByUser_Id(id);
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitle(title);
    }

    public List<Post> findAllByCategoryId(int id) {
        return postRepository.findAllByCategoryId(id);
    }

    public List<Post> findByPublishDateBefore(Date date) {
        return postRepository.findByPublishDateBefore(date);
    }
}
