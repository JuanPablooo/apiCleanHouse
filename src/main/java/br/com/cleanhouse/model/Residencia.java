package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_residencias")
public class Residencia extends AtributosGenericos {



    private String informacoes;

    private Long quantidadeQuartos;

    private String numero;

    @ManyToOne
    private Endereco endereco;


}
