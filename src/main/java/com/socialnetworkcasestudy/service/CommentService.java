package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.model.Friend;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment save(Comment comment);

    void delete(Long id);

    Comment findById( Long id);

    Comment findAllById(Long id);


}
