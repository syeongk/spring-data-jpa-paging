package study.springdatajpa.paging.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import study.springdatajpa.paging.domain.Post;
import study.springdatajpa.paging.repository.PostRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public List<Post> getPosts(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Post> pageOfPosts = postRepository.findAllByOrderByCreatedAtDesc(pageable);
        return pageOfPosts.getContent();
    }
}
