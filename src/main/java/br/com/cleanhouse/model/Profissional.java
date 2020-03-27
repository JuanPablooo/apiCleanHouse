package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "tbl_profissionais")
@Data
public class Profissional extends AtributosGenericos {

    @OneToOne
    private Usuario usuario;


    @NotNull
    private String nomeCompleto;

    private String cpf;

    @Past(message= "a data deve estar no passado")
    private Instant dataNascimento;


    private String fotoPerfil;

    private String videoPerfil;

    private String telefoneFixo;
    private String celular;

    @ManyToMany
    @JoinTable(
            name = "tbl_profissional_endereco",
            joinColumns = @JoinColumn(name = "profissional_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;


}
