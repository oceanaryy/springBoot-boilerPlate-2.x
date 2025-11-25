package com.hyeonjae.boilerplate.domain.board.repository;

import com.hyeonjae.boilerplate.domain.account.domain.Account;
import com.hyeonjae.boilerplate.domain.board.domain.PostLike;
import com.hyeonjae.boilerplate.domain.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    Integer countByPost(Post post);
    List<PostLike> findByWriter(Account account);
    boolean existsByWriterAndPost(Account account, Post post);
    Optional<PostLike> findByWriterAndPost(Account account, Post post);
}
