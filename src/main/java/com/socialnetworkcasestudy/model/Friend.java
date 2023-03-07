package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "user_Friend",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend _id"))
    private Set<User> users =new HashSet<>();


    @Enumerated(EnumType.STRING)
    private RelationshipType relationshipType;

    @Enumerated(EnumType.STRING)
    private FriendshipStatus friendshipStatus;

    private Instant createdAt;

    private Instant updatedAt;
}
