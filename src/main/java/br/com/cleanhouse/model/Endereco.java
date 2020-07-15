package br.com.cleanhouse.model;
import br.com.cleanhouse.model.AtributosGenericos;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tbl_enderecos")
public class Endereco extends AtributosGenericos {

    @NotNull
    private String numero;

    @NotNull
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String rua;

    @NotNull
    private String bairro;

    @NotNull
    private String estado;

    @NotNull
    private String pais;

    private String complemento;

    private String pontoReferencia;
}
