package com.example.cloneinstagram.board.dto;

import com.example.cloneinstagram.board.entity.Board;
import com.example.cloneinstagram.comment.dto.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MainFeedDto {
    private Long boardId;
    private String imageUrl;
    private String contents;
    private LocalDateTime createdAt;
    private List<CommentResponseDto> commentList;

    public MainFeedDto(Board board, List<CommentResponseDto> commentList) {
        this.boardId = board.getId();
        this.imageUrl = board.getImageUrl();
        this.contents = board.getContents();
        this.createdAt = board.getCreatedAt();
        this.commentList = commentList;
    }
}