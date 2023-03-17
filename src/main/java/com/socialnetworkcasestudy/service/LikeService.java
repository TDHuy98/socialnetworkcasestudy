package com.socialnetworkcasestudy.service;

import com.socialnetworkcasestudy.model.Likes;

import java.util.List;

public interface LikeService {
    List<Likes> findAll();

    Likes findById(long id);


    Likes save(Likes likes);


    void delete(long id);

    List<Likes> findByPostId(int id);

    Long coutLikeByPostId(int id);
}
