package com.example.wantedpreonboardingbackend.board.repository;

import com.example.wantedpreonboardingbackend.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {
}
