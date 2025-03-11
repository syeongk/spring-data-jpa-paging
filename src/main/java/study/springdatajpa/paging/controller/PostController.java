package study.springdatajpa.paging.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springdatajpa.paging.domain.Post;
import study.springdatajpa.paging.service.PostService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public List<Post> getPosts(@RequestParam int pageNumber, @RequestParam int pageSize){
        return postService.getPosts(pageNumber, pageSize);
    }
}
