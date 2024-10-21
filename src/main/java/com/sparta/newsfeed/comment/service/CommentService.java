package com.sparta.newsfeed.comment.service;

import com.sparta.newsfeed.comment.dto.CommentRequestDto;
import com.sparta.newsfeed.comment.dto.CommentResponseDto;
import com.sparta.newsfeed.comment.repository.CommentRepository;
import com.sparta.newsfeed.entity.Comment;
import com.sparta.newsfeed.entity.Feed;
import com.sparta.newsfeed.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final FeedRepository feedRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto, Long feedId, Long userId) {
        Feed feed = feedRepository.findFeedById(feedId);
        User user = userRepository.findUserById(userId);

        // 새로운 댓글 생성
        Comment comment = Comment.from(requestDto, feed, user);
        Comment savedComment = commentRepository.save(comment);

        // 저장된 댓글을 CommentResponseDto로 반환
        return new CommentResponseDto(savedComment);
    }

    @Transactional
    public void updateComment(CommentRequestDto requestDto, Long feedId, Long commentId) {
        // Feed와 Comment를 각각 조회
        feedRepository.findfeedById(feedId);
        Comment comment = commentRepository.findfeedById(commentId);
        // 댓글 내용 수정
        comment.updateComment(requestDto.getComment());
        commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long feedId, Long commentId) {
        // Feed와 Comment를 각각 조회
        feedRepository.findfeedById(feedId);
        Comment comment = commentRepository.findCommentById(commentId);

        // 댓글 삭제
        commentRepository.deleteById(commentId);
    }
    @Transactional
    public List<CommentResponseDto> getCommentsByFeedId(Long feedId) {
        // Feed 조회
        Feed feed = feedRepository.findfeedById(feedId)
                .orElseThrow(() -> new ResourceNotFoundException("Feed not found"));

        // 해당 Feed에 달린 댓글 목록 조회
        List<Comment> comments = commentRepository.findByfeedId(feedId);
        return comments.stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }
}
