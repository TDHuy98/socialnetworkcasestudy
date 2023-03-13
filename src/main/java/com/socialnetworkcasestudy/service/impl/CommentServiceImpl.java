package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.repository.UserCommentRepository;
import com.socialnetworkcasestudy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    UserCommentRepository userCommentRepository;

    @Override
    public List<Comment> findAll() {
        return userCommentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return userCommentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        userCommentRepository.deleteById(id);

    }

    @Override
    public Comment findById(Long id) {
        return userCommentRepository.findById(id).get();
    }

    @Override
    public  Comment findAllById(Long id) {
        return  userCommentRepository.findById(id).get();
    }
}
