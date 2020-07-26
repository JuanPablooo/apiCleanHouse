package br.com.cleanhouse.model;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_profissionais")
public class Profissional extends AtributosGenericos {

    @OneToOne
    private Usuario usuario;


    @NotNull
    private String nomeCompleto;

    @CPF
    @Column(unique = true)
    private String cpf;

    @Past(message= "a data deve estar no passado")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String fotoPerfil;

    private String videoPerfil;

    private String telefoneFixo;
    private String celular;

    @OneToOne(cascade = {CascadeType.ALL})
    private Servico servicos;


    @ManyToMany
    @JoinTable(
            name = "tbl_profissional_endereco",
            joinColumns = @JoinColumn(name = "profissional_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;

<<<<<<< HEAD
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "tbl_profissional_regiao",
            joinColumns = @JoinColumn(name= "profissional_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_regiao")
    )
    private List<Regiao> regioes;


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataNascimento);
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getVideoPerfil() {
        return videoPerfil;
    }

    public void setVideoPerfil(String videoPerfil) {
        this.videoPerfil = videoPerfil;
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

    public Servico getServicos() {
        return servicos;
    }

    public void setServicos(Servico servicos) {
        this.servicos = servicos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }
=======
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getVideoPerfil() {
		return videoPerfil;
	}

	public void setVideoPerfil(String videoPerfil) {
		this.videoPerfil = videoPerfil;
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

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	
>>>>>>> 717dd2e1a1854290badbe126bd259a1bfb988fa2

    public void setRegioes(List<Regiao> regioes) {
        this.regioes = regioes;
    }
}
