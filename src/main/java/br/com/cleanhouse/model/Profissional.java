package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;

@Entity
@Table(name = "tbl_profissionais")
@Data
public class Profissional extends AtributosGenericos{


    @NotNull
    private String nomeCompleto;

    private String senha;

    @NotNull
    @Email
    private String email;

    private String cpf;

    @Past(message= "a data deve estar no passado")
    private Instant dataNascimento;

    @OneToOne
    private Endereco endereco;

}
