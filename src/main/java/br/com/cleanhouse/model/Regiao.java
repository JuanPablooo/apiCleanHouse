package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_regiao")
public class Regiao extends AtributosGenericos {

    private String nome;

    private String estado;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_regiao")
    private List<Cidade> cidades;


}
