package com.socialnetworkcasestudy.service.impl;

import com.socialnetworkcasestudy.model.Likes;
import com.socialnetworkcasestudy.repository.UserLikeRepository;
import com.socialnetworkcasestudy.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LikeImpl implements LikeService {
    @Autowired
    UserLikeRepository userLikeRepository;

    @Override
    public List<Likes> findAll() {
        return userLikeRepository.findAll();
    }


    @Override
    public Likes findById(long id) {
        return userLikeRepository.findById(id).get();
    }


    @Override
    public Likes save(Likes likes) {
        return userLikeRepository.save(likes);
    }

    @Override
    public void delete(long id) {
        userLikeRepository.deleteById(id);

    }

    @Override
    public List<Likes> findByPostId(int id) {
        return null;
    }

    @Override
    public Long coutLikeByPostId(int id) {
        List<Likes> newList = new ArrayList<>();
        List<Likes> tg = userLikeRepository.findAll();
        for (int i = 0; i < tg.size(); i++) {
            if (tg.get(i).getPostId()==id){
                newList.add(tg.get(i));
            }
        }
        return (long) tg.size();
    }
}
