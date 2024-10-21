//package com.sparta.newsfeed.friend.service;
//
//import com.sparta.newsfeed.entity.FriendshipStatus;
//import com.sparta.newsfeed.friend.Friend;
//import com.sparta.newsfeed.friend.repository.FriendRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FriendService {
//
//    private final FriendRepository friendRepository;
//
//    public FriendService(FriendRepository friendRepository) {
//        this.friendRepository = friendRepository;
//    }
//
//    public void createFriends(Long toId) throws Exception {
//
//        // 현재 로그인 되어 있는사람
//        Long fromId =
//
//        // 유저 정보를 모두 가져옴
//        Users fromUser = userRepository.findByid(fromId).orElseThrow(() -> new Exception("회원 조회 실패"));
//        Users toUser = userRepository.findByid(toId).orElseThrow(() -> new Exception("회원 조쇠 실패"));
//
//        // 받는 사람측에 저장될 친구 요청
//        Friend friendFrom = Friend.builder()
//                .users(fromUser)
//                .user_id(fromId)
//                .friend_id(toId)
//                .status(FriendshipStatus.WAITING)
//                .isFrom(true)
//                .bulid();
//
//        // 보내는 사람 쪽에 저장될 친구 요청
//        Friend friendTo = Friend.builder()
//                .users(toUser)
//                .user_id(toId)
//                .friend_id(fromId)
//                .status(FriendshipStatus.WAITING)
//                .isFrom(false)
//                .bulid();
//
//        // 각각의 유저 리스트에 저장
//        fromUser.get-----().add(friendTo);
//        toUser.get-----().add(friendFrom);
//
//        // 저장을 먼저 하는 이유는, 그래야 서로의 친구요청 번호가 생성되기 때문.
//        friendRepository.save(friendTo);
//        friendRepository.save(friendFrom);
//
//        // 매칭되는 친구요청의 아이디를 서로 저장한다.
//        friendTo.setCounterparId(friendFrom.getId());
//        friendFrom.setCounterpartId(friendTo.getId());
//    }
//
//    // 친구 삭제
//    public void deleteFriends(Long id) {
//        friendRepository.deleteById(id);
//    }
//}