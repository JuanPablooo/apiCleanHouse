package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table( name = "tbl_cidades")
public class Cidade extends AtributosGenericos {

    private String nome;

}
