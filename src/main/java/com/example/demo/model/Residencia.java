package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_residencias")
public class Residencia extends AtributosGenericos {

    private String numero;

    @ManyToOne
    private Endereco endereco;

    private String informacoes;

    private Long quantidadeQuartos;
}
