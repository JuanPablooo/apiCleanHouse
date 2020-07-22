package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Data
public class ProfissionalDTO {

    private Long id;
    private Usuario usuario;
    private String nomeCompleto;
    private String cpf;
    private String dataNascimento;
    private String telefoneFixo;
    private String celular;
    private Servico servicos;
    private List<Endereco> enderecos;
    private List<Cidade> cidades;

    public ProfissionalDTO(Profissional profissional){

        this.id = profissional.getId();
        this.usuario = profissional.getUsuario();
        this.nomeCompleto = profissional.getNomeCompleto();
        this.dataNascimento = profissional.getDataNascimento();
        this.celular = profissional.getCelular();
        this.telefoneFixo = profissional.getTelefoneFixo();
        this.cpf = profissional.getCpf();
        this.enderecos = profissional.getEnderecos();
        this.servicos = profissional.getServicos();
        this.cidades = profissional.getCidades();

    }


}
