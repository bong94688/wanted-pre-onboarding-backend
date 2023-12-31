package com.example.wantedpreonboardingbackend.board.service;

import com.example.wantedpreonboardingbackend.board.dto.BoardDto;
import com.example.wantedpreonboardingbackend.board.dto.PageInfoDTO;
import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.board.repository.BoardRepository;
import com.example.wantedpreonboardingbackend.board.repository.PageRepository;
import com.example.wantedpreonboardingbackend.member.entity.CustomUserDetails;
import com.example.wantedpreonboardingbackend.member.entity.Member;
import com.example.wantedpreonboardingbackend.member.reposiitory.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nonapi.io.github.classgraph.utils.LogNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {


    private final BoardRepository boardRepository;

    private final PageRepository pageRepository;


    private final MemberRepository memberRepository;
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

       Member member =  memberRepository.findByUsername(boardDto.getUsername()).orElseThrow(EntityNotFoundException::new);

        Board board = boardDto.creatBoard();
        board.setMember(member);
      Board saveboBoard = boardRepository.save(board);


        return saveboBoard.getId();
    }

    public BoardDto updateTodo(BoardDto boardDto, CustomUserDetails customUserDetails){

      Board board = boardRepository.findById(boardDto.getId()).orElseThrow(EntityNotFoundException::new);
        if (!customUserDetails.getUser().getUsername().equals(board.getMember().getUsername())) {
            throw new AccessDeniedException("User does not have permission to delete this board");
        }

      board.setText(boardDto.getText());



        return boardDto;
    }
    public BoardDto deleteboard(int boardnumber, CustomUserDetails customUserDetails){

        Board board = boardRepository.findById(boardnumber).orElseThrow(EntityNotFoundException::new);

        System.out.println(board.getMember().getUsername());
        System.out.println(customUserDetails.getUser().getUsername());
        if (!customUserDetails.getUser().getUsername().equals(board.getMember().getUsername())) {
            throw new AccessDeniedException("User does not have permission to delete this board");
        }

        BoardDto boardDto = BoardDto.of(board);

        boardRepository.delete(board);

        return boardDto;
    }
    public BoardDto searchboard(int boardnumber){

        Board board = boardRepository.findById(boardnumber).orElseThrow(EntityNotFoundException::new);
        BoardDto boardDto = BoardDto.of(board);

        System.out.println("sevice단!!"+board);
//        boardRepository.findById(boardnumber);

        return boardDto;
    }

    public Page<BoardDto> pageboardList(Pageable pageable){

        Page<Board> boardList = boardRepository.getBoardPage(pageable);

//        List<BoardDto> boardDtoList = boardList.getContent() // Page에서 List<Board>를 가져옵니다.
//                .stream() // 스트림을 생성합니다.
//                .map(board -> convertToDto(board)) // 각 Board 객체를 BoardDto로 변환합니다.
//                .collect(Collectors.toList());
//        Page<Board> boardList = boardRepository.getBoardPage(pageable);

        Page<BoardDto> boardDtoPage = boardList.map(board -> convertToDto(board));

        return boardDtoPage;
    }

    private BoardDto convertToDto(Board board) {
     return  BoardDto.of(board);
    }

//    private BoardDto convertToDto(Board board) {
//
//        return BoardDto.of(board);
//    }

    public PageInfoDTO getPageInfo(Long pageId) {
        PageInfoDTO pageInfo = new PageInfoDTO();
//        pageInfo.setPageTitle("페이지 제목"); // 페이지 제목 설정

        pageRepository.getPageInfo(pageId);

        return pageInfo;
    }
}
