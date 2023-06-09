package com.example.cloneinstagram.member.dto;

import com.example.cloneinstagram.board.dto.BoardResponseDto;
import com.example.cloneinstagram.board.entity.Board;
import com.example.cloneinstagram.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MyFeedResponseDto {
    private Long memberId;
    private String nickName;
    private String img;
    private String contents;
    private int followerCnt;
    private int followingCnt;
    private List<BoardResponseDto> boardResponseDtoList;

    public MyFeedResponseDto(Member member){
        this.memberId = member.getId();
        this.nickName = member.getNickName();
        this.img = member.getImg();
        this.contents = member.getContents();
    }

    public void setBoardList(List<Board> boardList) {
        this.boardResponseDtoList = boardList.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }
}
