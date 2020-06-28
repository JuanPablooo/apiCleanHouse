package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tbl_residencias")
public class Residencia extends AtributosGenericos {

    private Long quantidadeQuartos;

    @OneToOne
    @NotNull
    private Endereco endereco;

}
