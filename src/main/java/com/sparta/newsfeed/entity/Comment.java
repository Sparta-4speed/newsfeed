package com.sparta.newsfeed.entity;

import com.sparta.newsfeed.comment.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FeedId",nullable = false)
    private Feed feed;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;

    @Column(nullable = false)
    private String comment;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;

    // 댓글 데이터 수정
    public void updateComment(String Comment) {
        this.comment =comment;
        this.updatedAt = LocalDateTime.now(); //수정시간 갱신
    }
}