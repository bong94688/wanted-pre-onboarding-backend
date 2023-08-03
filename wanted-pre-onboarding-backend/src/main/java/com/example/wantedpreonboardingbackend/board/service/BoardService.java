package com.example.wantedpreonboardingbackend.board.service;

import com.example.wantedpreonboardingbackend.board.dto.BoardDto;
import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.board.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nonapi.io.github.classgraph.utils.LogNode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {


    private final BoardRepository boardRepository;

    public List<BoardDto> getboardlist(){

        List<Board> boardList = boardRepository.findAll();

        List<BoardDto> boardDtoList = new ArrayList<>();

        for( Board board: boardList){
            BoardDto boardDto = BoardDto.of(board);

            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

    public int saveboard(BoardDto boardDto){

        Board board = boardDto.creatBoard();

      Board saveboBoard = boardRepository.save(board);


        return saveboBoard.getId();
    }

    public int updateTodo(BoardDto boardDto){

       Board board = boardRepository.findById(boardDto.getId()).orElseThrow(EntityNotFoundException::new);
       Board updateboard = boardDto.creatBoard();
       board = updateboard;

    return boardDto.getId();
    }


    public int deleteboard(int boardnum){

       Board board =  boardRepository.findById(boardnum).orElseThrow(EntityNotFoundException::new);

       int deletenum = board.getId();
        boardRepository.delete(board);


        return deletenum;
    }




}
