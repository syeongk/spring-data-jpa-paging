package study.springdatajpa.paging.converter;

import org.springframework.data.domain.Page;
import study.springdatajpa.paging.domain.Post;
import study.springdatajpa.paging.dto.PostDTO;

public class PostConverter {
    public static PostDTO.PostResponseDTO toPostDTO (Page<Post> pagePost) {
        return PostDTO.PostResponseDTO.builder()
                .content(pagePost.getContent())
                .totalPages(pagePost.getTotalPages())
                .build();
    }
}
