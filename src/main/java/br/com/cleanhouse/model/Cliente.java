package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tbl_clientes")
@Data
public class Cliente extends AtributosGenericos{

    @OneToOne
    private Usuario usuario;
    
    @NotNull
    private String nomeCompleto;

    @NotNull
    private String dataNascimento;


    @CPF
    @NotNull
    private String cpf;

    private String fotoPerfil;

    private String telefoneFixo;

    @NotNull
    private String celular;

    @OneToMany
    @JoinColumn(name = "cliente_id")
   private List<Residencia> residencias;

    



}
