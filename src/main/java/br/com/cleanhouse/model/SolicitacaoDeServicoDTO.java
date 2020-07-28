package br.com.cleanhouse.model;

import lombok.Data;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
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


//    public String getData() {
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        return format.format(data);
//    }


    public SolicitacaoDeServicoDTO(Long idCliente, String cliente, Long idProfissional, String profissional, Date data, Residencia residencia, Servico servicos, double preco, String observacao, String status) {
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.idProfissional = idProfissional;
        this.profissional = profissional;
        this.data = data;
        this.residencia = residencia;
        this.servicos = servicos;
        this.preco = preco;
        this.observacao = observacao;
        this.status = status;
    }

    public SolicitacaoDeServicoDTO() {
    }
}

