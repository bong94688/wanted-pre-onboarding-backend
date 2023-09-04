package com.example.wantedpreonboardingbackend.board.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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


    @OneToMany(mappedBy = "id")
    @JsonBackReference
    private List<Page> children;

    @ManyToOne
    @JsonManagedReference
    private Page parent;
}
