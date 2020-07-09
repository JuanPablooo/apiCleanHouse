package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_upload")
public class Upload extends AtributosGenericos {


    private String nome;

    private String tipo;


}
