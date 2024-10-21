package com.sparta.newsfeed.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Friends")
@NoArgsConstructor
public class Friend extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private Users users;

    private long user_id;
    private long friend_id;
    private FriendshipStatus status;
    private boolean isFrom;


}
