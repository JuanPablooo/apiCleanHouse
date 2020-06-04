package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_residencias")
public class Residencia extends AtributosGenericos {

    private Long quantidadeQuartos;

    @OneToOne
    private Endereco endereco;

}
