package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    Comment findById(long id);

    Comment save(Comment comment);

    void delete(long id);


}
