package br.com.cleanhouse.model;


import lombok.Data;

import java.util.Date;

@Data
public class SolicitacoesDTO {


    private ClienteDTO clienteDTO;
    private ProfissionalDTO profissionalDTO;
    private Date data;
    private Residencia residencia;
    private Servico servicos;
    private double preco;
    private String observacao;
    private String status;

//    public SolicitacoesDTO(ClienteDTO clienteDTO, ProfissionalDTO profissionalDTO, SolicitacaoDeServico solicitacaoDeServico){
//        this.clienteDTO = clienteDTO;
//        this.profissionalDTO = profissionalDTO;
//        this.data = solicitacaoDeServico.getData();
//        this.residencia = solicitacaoDeServico.getResidencia();
//        this.servicos = solicitacaoDeServico.getServicos();
//        this.preco = solicitacaoDeServico.getPreco();
//        this.observacao = solicitacaoDeServico.getObservacao();
//        this.status = solicitacaoDeServico.getStatus();
//    }

}
