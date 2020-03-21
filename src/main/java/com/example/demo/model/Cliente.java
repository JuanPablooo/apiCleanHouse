package com.example.demo.model;

import lombok.Data;
import org.hibernate.annotations.common.reflection.XMethod;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_clientes")
@Data
public class Cliente extends AtributosGenericos{


    
    @NotNull
    private String nomeCompleto;

    @NotNull
    private String dataNascimento;

    @NotNull
    private String email;

    @NotNull
    private String cpf;

    private String fotoPerfil;

    private String telefoneFixo;

    @NotNull
    private String celular;

    @NotNull
    @Size(min=8, max=20, message="A senha deve conter no mínimo 8 caracteres e no máximo 20!")
    private String senha;



}
