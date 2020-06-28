package br.com.cleanhouse.model;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private String pais;
    private String complemento;
    private String pontoReferencia;

    public EnderecoDTO(Endereco endereco){
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();
        this.estado = endereco.getEstado();
        this.pais = endereco.getPais();
        this.complemento = endereco.getComplemento();
        this.pontoReferencia = endereco.getPontoReferencia();
    }

}
