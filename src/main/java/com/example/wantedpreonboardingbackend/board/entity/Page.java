package com.example.wantedpreonboardingbackend.board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pageTitle;

    private String content;

    @OneToMany(mappedBy = "parent")
    private List<Page> children;

    @ManyToOne
    private Page parent;
}
