package com.example.wantedpreonboardingbackend.board.entity;


import com.example.wantedpreonboardingbackend.member.entity.Member;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private String text;

    private boolean checked;


}
