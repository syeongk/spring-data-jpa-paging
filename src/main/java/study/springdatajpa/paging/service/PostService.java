package study.springdatajpa.paging.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import study.springdatajpa.paging.converter.PostConverter;
import study.springdatajpa.paging.domain.Post;
import study.springdatajpa.paging.dto.PostDTO;
import study.springdatajpa.paging.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;
import static study.springdatajpa.paging.converter.PostConverter.toPostDTO;

@AllArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    // 게시글 최신순으로 가져옴
    public List<Post> getPosts(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        Page<Post> pageOfPosts = postRepository.findAllByOrderByCreatedAtDesc(pageable);
        return pageOfPosts.getContent();
    }

    // 게시글 조회 수, 댓글 수 등을 지정해서 오름차순이나 내림차순으로 가져옴
    public PostDTO.PostResponseDTO getPostsSortBy(int pageNumber, int pageSize, String sortBy, String direction){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? ASC : DESC;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sortDirection, sortBy);
        Page<Post> pageOfPosts = postRepository.findAll(pageable);

        return toPostDTO(pageOfPosts);
    }

    // Pageable 테스트 응답
    public Pageable getPageable(int pageNumber, int pageSize, String sortBy, String direction){
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? ASC : DESC;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, sortDirection, sortBy);
        return pageable;
    }
}
