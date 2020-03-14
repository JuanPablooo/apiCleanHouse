package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_profissionais")
@Data
public class Profissional extends AtributosGenericos{

    @NotEmpty
    private String nome;

    private String cpf;

    private String dataNascimento;

    private String rua;

    private String bairro;

    private String cidade;

    private String estado;


    @Override
    public String toString() {
        return "Profissional{" +
                ", nome='" + nome + '\'' +
                '}';
    }


}
