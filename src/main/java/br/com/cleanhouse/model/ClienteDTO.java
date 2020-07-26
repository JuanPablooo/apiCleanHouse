package br.com.cleanhouse.model;

import lombok.Data;
import java.util.List;

@Data
public class ClienteDTO {

    private Long id;
    private Usuario usuario;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String telefoneFixo;
    private String celular;
    private List<Residencia> residencias;

    public ClienteDTO(Cliente cliente){

        this.id = cliente.getId();
        this.usuario = cliente.getUsuario();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.telefoneFixo = cliente.getTelefoneFixo();
        this.celular = cliente.getCelular();
        this.residencias = cliente.getResidencias();

    }


}
