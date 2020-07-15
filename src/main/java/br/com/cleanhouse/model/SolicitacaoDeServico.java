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


    /*@ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;*/


    private Date data;


    @OneToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;


    @OneToOne(cascade = CascadeType.REFRESH)
    private Servico servicos;


    private double preco;


    private String observacao;


    private String status;

}
