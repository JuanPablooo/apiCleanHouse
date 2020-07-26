package br.com.cleanhouse.model;

import lombok.Data;

import java.util.List;

@Data
public class ClientePrincipalDTO {

        private Long id;
        private Usuario usuario;
        private String nomeCompleto;
        private String dataNascimento;
        private String cpf;
        private String telefoneFixo;
        private String celular;
        private List<Residencia> residencias;
        private List<SolicitacoesDTO> solicitacoesDTO;

        public ClientePrincipalDTO(ClienteDTO clienteDTO, List<SolicitacoesDTO> solicitacoesDTO){

            this.id = clienteDTO.getId();
            this.usuario = clienteDTO.getUsuario();
            this.nomeCompleto = clienteDTO.getNomeCompleto();
            this.dataNascimento = clienteDTO.getDataNascimento();
            this.cpf = clienteDTO.getCpf();
            this.telefoneFixo = clienteDTO.getTelefoneFixo();
            this.celular = clienteDTO.getCelular();
            this.residencias = clienteDTO.getResidencias();
            this.solicitacoesDTO = solicitacoesDTO;

        }

}
