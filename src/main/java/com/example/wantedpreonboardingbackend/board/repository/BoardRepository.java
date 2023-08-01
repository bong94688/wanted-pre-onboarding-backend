package com.example.wantedpreonboardingbackend.board.repository;

import com.example.wantedpreonboardingbackend.board.entity.Board;
import com.example.wantedpreonboardingbackend.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Integer> {

    Optional<Board> findByMember(Member member);
}
