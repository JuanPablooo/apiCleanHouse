package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

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
    /*
    * @DateTimeFormat(pattern="dd/MM/yyyy")
      private Calendar dataFinalizacao;
    *
    * */


    @NotNull
    private String nomeCompleto;

    @CPF
    private String cpf;

    @Past(message= "a data deve estar no passado")
    private Instant dataNascimento;


    private String fotoPerfil;

    private String videoPerfil;

    @ManyToMany
    @JoinTable(
            name = "tbl_profissional_endereco",
            joinColumns = @JoinColumn(name = "profissional_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;


}
