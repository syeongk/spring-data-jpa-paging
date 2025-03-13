package study.springdatajpa.paging.dto;

import lombok.Builder;
import lombok.Getter;
import study.springdatajpa.paging.domain.Post;

import java.util.List;

public class PostDTO {
    @Getter
    @Builder
    public static class PostResponseDTO {
        private List<Post> content;
        private Integer totalPages;
    }
}
