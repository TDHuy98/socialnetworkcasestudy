package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.repository.UserCommentRepository;
import com.socialnetworkcasestudy.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserCommentRepository userCommentRepository;

    @Override
    public List<Comment> findAll() {
        return userCommentRepository.findAll();
    }


    @Override
    public Comment findById(long id) {
        return userCommentRepository.findById(id).get();
    }


    @Override
    public Comment save(Comment comment) {
        return userCommentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        userCommentRepository.deleteById(id);

    }

    @Override
    public List<CommentDto> findByPostId(Long id) {
        return userCommentRepository.findAllByPostId(id).stream().map(this::commentToCommentDto).toList();
    }

    private CommentDto commentToCommentDto(Comment comment) {
        return modelMapper.map(comment, CommentDto.class);
    }
}
