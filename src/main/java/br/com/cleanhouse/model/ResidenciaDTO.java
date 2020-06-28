package br.com.cleanhouse.model;

import lombok.Data;

@Data
public class ResidenciaDTO {

    private Long id;
    private Long idEndereco;
    private Long quantidadeQuartos;


    public ResidenciaDTO(Residencia residencia){
        this.id = residencia.getId();
        this.idEndereco = residencia.getEndereco().getId();
        this.quantidadeQuartos = residencia.getQuantidadeQuartos();
    }

}
