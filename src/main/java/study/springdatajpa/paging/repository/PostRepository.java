package study.springdatajpa.paging.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.springdatajpa.paging.domain.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);

    Page<Post> findAll(Pageable pageable);

    @Query("SELECT title FROM Post")
    Page<Post> findTitle(Pageable pageable);
}
