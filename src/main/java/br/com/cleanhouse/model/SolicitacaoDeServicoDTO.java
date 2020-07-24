package br.com.cleanhouse.model;

import lombok.Data;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Date;

@Data
public class SolicitacaoDeServicoDTO{

    private Long id;

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


//    public String getData() {
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        return format.format(data);
//    }

}

