package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Post;
import com.socialnetworkcasestudy.repository.UserPostRepository;
import com.socialnetworkcasestudy.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    UserPostRepository userPostRepository;

    @Override
    public List<Post> findAll() {
        return userPostRepository.findAll();
    }

    @Override
    public Post save(Post post) {
        return userPostRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        userPostRepository.deleteById(id);

    }

    @Override
    public Post findById(Long id) {
        return userPostRepository.findById(id).get();
    }
}
