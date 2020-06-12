package br.com.cleanhouse.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClienteDTO {

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
    private List<Residencia> residencias;

//top
	public ClienteDTO(Cliente cliente){

        this.id = cliente.getId();
        this.idUsuario = cliente.getUsuario().getId();
        this.email = cliente.getUsuario().getEmail();
        this.tipo = cliente.getUsuario().getTipo();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.fotoPerfil = cliente.getFotoPerfil();
        this.telefoneFixo = cliente.getTelefoneFixo();
        this.celular = cliente.getCelular();
        this.residencias = cliente.getResidencias();
    }

}
