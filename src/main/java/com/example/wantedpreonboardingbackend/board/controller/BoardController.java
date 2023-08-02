package com.example.wantedpreonboardingbackend.board.controller;


import com.example.wantedpreonboardingbackend.board.dto.BoardDto;
import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.board.service.BoardService;
import com.example.wantedpreonboardingbackend.dto.ResponseDTO;
import com.example.wantedpreonboardingbackend.member.entity.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;



    @GetMapping("/board/{boardid}")
    public ResponseEntity<?> searchList(//security에 있는 authentication에 접근
                                 @PathVariable int boardid, @AuthenticationPrincipal CustomUserDetails customUserDetails) {

        System.out.println(boardid);
        System.out.println(customUserDetails);

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



    @GetMapping("/board")
    public ResponseEntity<?> getTodoList(//security에 있는 authentication에 접근
             @AuthenticationPrincipal CustomUserDetails customUserDetails) {

        System.out.println(customUserDetails);

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
    public ResponseEntity<?> insertTodoList(@RequestBody BoardDto boardDto
    ,@AuthenticationPrincipal CustomUserDetails customUserDetails) {

        System.out.println(customUserDetails);
        boardDto.setUsername(customUserDetails.getUsername());
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

    @PutMapping("/board")
    public ResponseEntity<?> updateTodoList(@RequestBody BoardDto boardDto,
    @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        System.out.println(customUserDetails);

        ResponseDTO<BoardDto> response = new ResponseDTO<>();
        try {

            BoardDto updateboard = boardService.updateTodo(boardDto);


            response.setItem(boardDto);
            response.setStatusCode(HttpStatus.OK.value());
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            response.setErrorMessage(e.getMessage());
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(response);
        }
}

        @DeleteMapping("/board")
        public ResponseEntity<?> deleteboard(@RequestBody int boardnumber,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) {
            System.out.println(customUserDetails);

            ResponseDTO<BoardDto> response = new ResponseDTO<>();

            try {
               BoardDto boardDto =  boardService.deleteboard(boardnumber);
                response.setItem(boardDto);
                response.setStatusCode(HttpStatus.OK.value());
                return ResponseEntity.ok().body(response);
            } catch (Exception e) {
                response.setErrorMessage(e.getMessage());
                response.setStatusCode(HttpStatus.BAD_REQUEST.value());
                return ResponseEntity.badRequest().body(response);
            }
    }
}
