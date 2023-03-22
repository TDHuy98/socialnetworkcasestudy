package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.dto.CommentDto;
import com.socialnetworkcasestudy.model.Comment;
import com.socialnetworkcasestudy.repository.UserCommentRepository;
import com.socialnetworkcasestudy.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            commentDto.setFirstname(c.getUser().getFirstname());
            commentDto.setMiddlename(c.getUser().getMiddlename());
            commentDto.setLastname(c.getUser().getLastname());
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
        return userCommentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
        userCommentRepository.deleteById(id);

    }


}
