//package com.example.wantedpreonboardingbackend.board.service;
//
//import com.example.wantedpreonboardingbackend.board.dto.BoardDto;
//import com.example.wantedpreonboardingbackend.board.entity.Board;
//import com.example.wantedpreonboardingbackend.board.repository.BoardRepository;
//import com.example.wantedpreonboardingbackend.member.entity.Member;
//import com.example.wantedpreonboardingbackend.member.reposiitory.MemberRepository;
//import org.apache.juli.logging.Log;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//@Transactional
//class BoardServiceTest {
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    MemberRepository memberRepository;
//
//
//    public Member createMember(){
//        Member member = new Member();
//        member.setUsername("bong9468");
//        member.setPassword("1111");
//        return memberRepository.save(member);
//    }
//
//
//
//
//    public Board createboard()
//    {
//        Board board = new Board();
//        board.setText("테스트 상품");
//        board.setChecked(true);
//        board.setMember(createMember());
//        board = boardRepository.save(board);  // 이 줄을 추가합니다.
//        return board;
//    }
//
//
//
//    @Test
//    @DisplayName("보드 가져오기")
//    void getboardlist() {
////        Board board = createboard();
//////        board.setText("테스트 상품");
//////        board.setChecked(true);
//////        board.setMember(createMember());
//////        board = boardRepository.save(board);  // 이 줄을 추가합니다.
////        System.out.println(boardRepository.findByMember(board.getMember()));
////         assertEquals(boardRepository.findByMember(board.getMember()).get(), board);
//        Board board = createboard();
//
//        System.out.println(boardRepository.findAll());
//
//    }
//
//    @Test
//    void saveboard() {
//        Board board = createboard();
////        board.setText("테스트 상품");
////        board.setChecked(true);
////        board.setMember(createMember());
////        board = boardRepository.save(board);  // 이 줄을 추가합니다.
//        System.out.println(boardRepository.findByMember(board.getMember()));
//        assertEquals(boardRepository.findByMember(board.getMember()).get(), board);
//        //false -> 오류떠요
//    }
//
//
//    @Test
//    void updateTodo() {
//        Board board = createboard();
//       Optional<Board> updateboard = boardRepository.findByMember(board.getMember());
//        updateboard.get().setText("업데이트 합니다.");
//        System.out.println(boardRepository.findAll());
//    }
//
//    @Test
//    void deleteboard() {
//        Board board = createboard();
//        Optional<Board> updateboard = boardRepository.findByMember(board.getMember());
//        boardRepository.delete(updateboard.get());
//        System.out.println(boardRepository.findAll());
//    }
//}