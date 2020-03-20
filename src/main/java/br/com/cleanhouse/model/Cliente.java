package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_clientes")
@Data
public class Cliente extends AtributosGenericos{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
