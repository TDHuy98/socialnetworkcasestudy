package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
    private String content;
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post postId;
    @OneToMany
    @JoinColumn(name = "parentId")
    private Collection<Comment> comments = new ArrayList<>();

}
