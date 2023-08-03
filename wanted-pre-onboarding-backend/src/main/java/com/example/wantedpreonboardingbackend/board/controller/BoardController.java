package com.example.wantedpreonboardingbackend.board.controller;


import com.example.wantedpreonboardingbackend.board.dto.BoardDto;
import com.example.wantedpreonboardingbackend.board.service.BoardService;
import com.example.wantedpreonboardingbackend.dto.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<?> getTodoList(@RequestBody BoardDto boardDto) {

        ResponseDTO<BoardDto> response = new ResponseDTO<>();
        try {


            List<BoardDto> boardDtoList = boardService.getboardlist();
            response.setItems(boardDtoList);

            response.setStatusCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PostMapping("/board")
    public ResponseEntity<?> insertboard(@RequestBody BoardDto boardDto) {

        ResponseDTO<Integer> response = new ResponseDTO<>();


        try {
//            새로운 Todo저장
            int updateboardnum = boardService.saveboard(boardDto);

            response.setItem(updateboardnum);
            return ResponseEntity.ok().body(response);

        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }
    }

    //
    @PutMapping("/todo")
    public ResponseEntity<?> updateboard(@RequestBody BoardDto boardDto) {

        ResponseDTO<Integer> response = new ResponseDTO<>();
        try {
            int updateboardnum = boardService.updateTodo(boardDto);
            response.setItem(updateboardnum);
            response.setStatusCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }
//
//        }
//
//        @DeleteMapping("/todo")
//        public ResponseEntity<?> deleteTodoList(){
//
//
//
//            return null;
//        }


    }
    @PutMapping("/board")
    public ResponseEntity<?> deleteboard(@RequestBody BoardDto boardDto) {

        ResponseDTO<Integer> response = new ResponseDTO<>();
        try {
            int updateboardnum = boardService.updateTodo(boardDto);
            response.setItem(updateboardnum);
            response.setStatusCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }
//
//        }
//
    }
        @DeleteMapping("/todo")
        public ResponseEntity<?> deleteTodoList(@RequestBody int boardnum){
            ResponseDTO<Integer> response = new ResponseDTO<>();
            try {
                int delteboardnum = boardService.deleteboard(boardnum);
                response.setItem(delteboardnum);
                response.setStatusCode(HttpStatus.OK.value());
                return ResponseEntity.ok().body(response);
            } catch (Exception e) {
                response.setErrorMessage(e.getMessage());
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(response);
            }
        }

    }



