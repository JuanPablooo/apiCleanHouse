package br.com.cleanhouse.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_clientes")
public class Cliente extends AtributosGenericos{

    @NotNull(message = "Usuário é obrigatório!")
    @OneToOne
    private Usuario usuario;
    
    @NotNull(message = "Nome é obrigatório!")
    private String nomeCompleto;

    @NotNull(message = "Data de Nascimento é obrigatório!")
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;


    @CPF(message = "CPF invalido")
    @NotNull(message = "CPF é obrigatório!")
    @Column(unique = true)
    private String cpf;

    private String fotoPerfil;

    private String telefoneFixo;

    @NotNull(message = "Celular é obrigatório!")
    private String celular;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Residencia> residencias;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clienteId")
//    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<SolicitacaoDeServico> solicitacaoDeServicos;



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento(){

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataNascimento);
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Residencia> getResidencias() {
        return residencias;
    }

    public void setResidencias(List<Residencia> residencias) {
        this.residencias = residencias;
    }

    public List<SolicitacaoDeServico> getSolicitacaoDeServicos() {
        return solicitacaoDeServicos;
    }

    public void setSolicitacaoDeServicos(List<SolicitacaoDeServico> solicitacaoDeServicos) {
        this.solicitacaoDeServicos = solicitacaoDeServicos;
    }
}
