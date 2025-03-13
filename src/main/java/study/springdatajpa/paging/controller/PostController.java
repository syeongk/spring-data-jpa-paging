package study.springdatajpa.paging.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springdatajpa.paging.domain.Post;
import study.springdatajpa.paging.dto.PostDTO;
import study.springdatajpa.paging.service.PostService;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize){
        return postService.getPosts(pageNumber, pageSize);
    }

    @GetMapping("/posts/sort")
    public PostDTO.PostResponseDTO getPostsSortBy(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize, @RequestParam String sortBy, @RequestParam String direction){
        return postService.getPostsSortBy(pageNumber, pageSize, sortBy, direction);
    }

    @GetMapping("/posts/pageable")
    public Pageable getPageable(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize, @RequestParam String sortBy, @RequestParam String direction){
        return postService.getPageable(pageNumber, pageSize, sortBy, direction);
    }
}
