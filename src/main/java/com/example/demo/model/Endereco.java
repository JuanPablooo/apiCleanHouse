package com.example.demo.model;

import com.example.demo.model.AtributosGenericos;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_enderecos")
public class Endereco extends AtributosGenericos {



    private String cep;

    private String rua;

    private String bairro;

    private String estado;

    private String pais;

    private String referencia;
}