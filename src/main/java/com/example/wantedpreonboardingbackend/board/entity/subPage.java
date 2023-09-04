package com.example.wantedpreonboardingbackend.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.utils.LogNode;

@Data
@Entity
public class subPage {


    @Id
    @Column
    private Long id;

    @Column
    private int depth;

    @JoinColumn
    private Long parent_page_id;



    private String title;

}
