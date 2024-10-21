package com.sparta.newsfeed.friend.repository;

import com.sparta.newsfeed.friend.Friend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
