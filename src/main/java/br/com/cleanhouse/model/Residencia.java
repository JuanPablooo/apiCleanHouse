package br.com.cleanhouse.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "tbl_residencias")
public class Residencia extends AtributosGenericos {

    private Long quantidadeQuartos;

    @OneToOne
    @NotNull(message = "Endereço é obrigatório!")
    private Endereco endereco;

	public Long getQuantidadeQuartos() {
		return quantidadeQuartos;
	}

	public void setQuantidadeQuartos(Long quantidadeQuartos) {
		this.quantidadeQuartos = quantidadeQuartos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

}
