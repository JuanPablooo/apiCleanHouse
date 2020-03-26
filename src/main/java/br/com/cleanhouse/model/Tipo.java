package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tbl_tipos")
public class Tipo extends AtributosGenericos {
    private String nomeTipo;
}
