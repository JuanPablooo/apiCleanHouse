package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_comentarios")
public class Comentario extends AtributosGenericos{

    private String descricao;

}
