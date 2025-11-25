package com.hyeonjae.boilerplate.domain.board.service;

import com.hyeonjae.boilerplate.domain.account.domain.Account;
import com.hyeonjae.boilerplate.domain.board.domain.Post;
import com.hyeonjae.boilerplate.domain.board.dto.PostReqDto;
import com.hyeonjae.boilerplate.domain.board.exception.PostNotFoundException;
import com.hyeonjae.boilerplate.domain.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<Post> findAllDesc() {
        return postRepository.findAllByOrderByIdDesc();
    }

    @Transactional(readOnly = true)
    public Post findById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("id", postId));
    }

    @Transactional(readOnly = true)
    public List<Post> findByWriter(Account author) {
        return postRepository.findByWriter(author);
    }

    @Transactional(readOnly = true)
    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContains(title);
    }


    public Long create(PostReqDto.Create reqDto, Account account) {
        Post post = postRepository.save(reqDto.toEntity(account));
        return post.getId();
    }

    public void read(Long postId) {
        Post post = findById(postId);
        postRepository.updateViewCount(postId);
    }

    public void update(Long postId, PostReqDto.Update reqDto) {
        Post post = findById(postId);
        post.updatePost(reqDto.getTitle(), reqDto.getContent());
    }

    public void delete(Long postId) {
        Post post = findById(postId);
        postRepository.delete(post);
    }

}
