package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "tbl_servicos")
@Data
public class Servico extends AtributosGenericos {

    private Boolean passar_lavar_roupa;
    private Boolean cozinhar;
    private Boolean faxina;


}
