package com.hyeonjae.boilerplate.domain.board.repository;

import com.hyeonjae.boilerplate.domain.account.domain.Account;
import com.hyeonjae.boilerplate.domain.board.domain.Comment;
import com.hyeonjae.boilerplate.domain.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByWriter(Account account);
    List<Comment> findByPost(Post post);
}
