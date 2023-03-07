package com.socialnetworkcasestudy.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sourceId")
    private User source;
    @ManyToOne
    @JoinColumn(name = "targetId")
    private User target;
    @Enumerated(EnumType.STRING)
    private RelationshipType relationshipType;
    @Enumerated(EnumType.STRING)
    private FriendshipStatus friendshipStatus;

    private Instant createdAt;

    private Instant updatedAt;
}
