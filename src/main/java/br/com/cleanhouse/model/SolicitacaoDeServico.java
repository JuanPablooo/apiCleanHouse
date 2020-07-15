package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tbl_solicitacao_servico")
@Data
public class SolicitacaoDeServico extends AtributosGenericos{


    private Date data;


    @OneToOne(cascade = CascadeType.REFRESH)
    private Residencia residencia;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicos_id")
    private Servico servicos;


    private double preco;


    private String observacao;


    private String status;

}
