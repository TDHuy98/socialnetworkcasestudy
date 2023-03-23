package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.repository.UserCommentRepository;
import com.socialnetworkcasestudy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {


    @Autowired
    private UserCommentRepository userCommentRepository;

    @Override
    public List<CommentDto> findAll() {
        List<CommentDto> newList = new ArrayList<CommentDto>();
        for (Comment c : userCommentRepository.findAll()) {
            CommentDto commentDto = new CommentDto();
            commentDto.setId(c.getId());
            commentDto.setContent(c.getContent());
            commentDto.setUserId(c.getUser().getId());
            commentDto.setPostId(c.getPostId());
            commentDto.setProfile(c.getUser().getProfile());
            commentDto.setFirstName(c.getUser().getFirstName());
            commentDto.setMiddleName(c.getUser().getMiddleName());
            commentDto.setLastName(c.getUser().getLastName());
            commentDto.setCreatedAt(c.getCreatedAt());
            newList.add(commentDto);
        }
        return newList;
    }


    @Override
    public Comment findById(long id) {
        return userCommentRepository.findById(id).get();
    }


    @Override
    public Comment save(Comment comment) {
        comment.setCreatedAt(Date.valueOf(LocalDate.now()));
        return userCommentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        userCommentRepository.deleteById(id);

    }


}
