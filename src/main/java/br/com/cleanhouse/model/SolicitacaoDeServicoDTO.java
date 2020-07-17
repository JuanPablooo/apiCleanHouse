package br.com.cleanhouse.model;

import lombok.Data;

import java.util.Date;

@Data
public class SolicitacaoDeServicoDTO extends AtributosGenericos{

    private Long idCliente;

    private String cliente;

    private Long idProfissional;

    private String profissional;

    private Date data;

    private Residencia residencia;

    private Servico servicos;

    private double preco;

    private String observacao;

    private String status;

}