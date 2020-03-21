package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.Instant;

@Entity
@Table(name = "tbl_profissionais")
@Data
public class Profissional extends AtributosGenericos{

    @NotEmpty
    private String nome;

    private String cpf;

    @Past(message= "a data deve estar no passado")
    private Instant dataNascimento;


    private String rua;

    private String bairro;

    private String cidade;

    private String estado;

}
