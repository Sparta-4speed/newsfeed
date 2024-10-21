//package com.sparta.newsfeed.friend.controller;
//
//import com.sparta.newsfeed.friend.service.FriendService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/friends")
//public class FriendController {
//
//    private final FriendService friendsService;
//
//    public FriendController(FriendService friendsService) {
//        this.friendsService = friendsService;
//    }
//
//    //친추
//    @PostMapping("/{userId}/add")
//    public String createFriends(@PathVariable ("userId") Long id) throws Exception {
//        if(!usersService.isExistByid(id)) {
//            throw new Exception("대상 회원이 존재하지 않습니다.");
//        }
//        friendsService.createFriends(id);
//        return "친추 성공";
//    }
//
//    //친삭
//    @DeleteMapping("/{userId}/delete")
//    public ResponseEntity <String> deleteFriends(@PathVariable ("userId") Long id) {
//        friendsService.deleteFriends(id);
//        return ResponseEntity.ok("친삭 성공");
//    }
//
//    //친조
//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<?> getWaitingFriendInfo() throws Exception {
//        return friendsService.getWaitingFriendList()
//    }
//}
