package br.com.cleanhouse.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProfissionalDTO {

    private Long id;
    private Long idUsuario;
    private String email;
    private String tipo;
    private String nomeCompleto;
    private String cpf;
    private Date dataNascimento;
    private String celular;
    private String telefoneFixo;
    private String fotoPerfil;
    private String videoPerfil;
    private List<Endereco> enderecos;

    public ProfissionalDTO(Profissional profissional){

        this.id = profissional.getId();
        this.idUsuario = profissional.getUsuario().getId();
        this.email = profissional.getUsuario().getEmail();
        this.tipo = profissional.getUsuario().getTipo();
        this.nomeCompleto = profissional.getNomeCompleto();
        this.dataNascimento = profissional.getDataNascimento();
        this.celular = profissional.getCelular();
        this.telefoneFixo = profissional.getTelefoneFixo();
        this.cpf = profissional.getCpf();
        this.fotoPerfil = profissional.getFotoPerfil();
        this.videoPerfil = profissional.getVideoPerfil();
        this.enderecos = profissional.getEnderecos();

    }

}
