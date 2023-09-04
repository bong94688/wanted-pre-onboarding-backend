package com.example.wantedpreonboardingbackend.board.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ParentPage {

    @Id
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


}
