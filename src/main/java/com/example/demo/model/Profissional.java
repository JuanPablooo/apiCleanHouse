package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_profissionais")
public class Profissional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
