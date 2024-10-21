package com.sparta.newsfeed.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Friends")
public class Friends extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long user_id;
    @Column
    private long friend_id;
    @Column
    private String status;
}
