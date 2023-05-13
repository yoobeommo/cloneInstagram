package com.example.cloneinstagram.love.service;

import com.example.cloneinstagram.board.entity.Board;
import com.example.cloneinstagram.board.repository.BoardRepository;
import com.example.cloneinstagram.commonDto.ResponseMsgDto;
import com.example.cloneinstagram.exception.CustomException;
import com.example.cloneinstagram.exception.ErrorCode;
import com.example.cloneinstagram.love.entity.BoardLove;
import com.example.cloneinstagram.love.repository.BoardLoveRepository;
import com.example.cloneinstagram.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardLoveService {

    private final BoardLoveRepository boardLoveRepository;
    private final BoardRepository boardRepository;

    // 피드 좋아요
    @Transactional
    public ResponseMsgDto boardLove(Long id, Member member) {
        try {
            if (boardLoveRepository.findByBoardIdAndMemberId(id, member.getId())) {
                boardLoveRepository.deleteByBoardIdAndMemberId(id, member.getId());
                return ResponseMsgDto.setSuccess(HttpStatus.OK.value(), "좋아요 취소 성공", null);
            } else {
                Board board = findBoardById(id);
                BoardLove boardLove = new BoardLove(board, member);
                boardLoveRepository.save(boardLove);
                return ResponseMsgDto.setSuccess(HttpStatus.OK.value(), "좋아요 등록 성공", null);
            }
        }catch(Exception e){
            return ResponseMsgDto.setFail(HttpStatus.BAD_REQUEST.value(), "실패");
        }
    }

    // 피드 존재 확인 메서드
    public Board findBoardById(Long id){
        return boardRepository.findById(id).orElseThrow(
                () -> new CustomException(ErrorCode.BOARD_NOT_FOUND)
        );
    }
}