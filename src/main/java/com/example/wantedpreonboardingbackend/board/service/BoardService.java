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

    public BoardDto updateTodo(BoardDto boardDto){

      Board board = boardRepository.findById(boardDto.getId()).orElseThrow(EntityNotFoundException::new);

      board = boardDto.creatBoard();



        return boardDto;
    }
    public BoardDto deleteboard(int boardnumber){

        Board board = boardRepository.findById(boardnumber).orElseThrow(EntityNotFoundException::new);


        BoardDto boardDto = BoardDto.of(board);

        boardRepository.delete(board);

        return boardDto;
    }


}
