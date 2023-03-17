package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findById(long id);

    Comment save(Comment comment);

    void delete(long id);

    List<Comment> findByPostId(int id);
}
