package br.com.cleanhouse.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_profissionais")
@Data
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
    private String telefoneFixo;
    private String celular;

    @OneToOne(cascade = {CascadeType.ALL})
    private Servico servicos;

    private int avaliacao;

    @ManyToMany
    @JoinTable(
        name = "tbl_profissional_endereco",
        joinColumns = @JoinColumn(name = "profissional_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "endereco_id")
    )
    private List<Endereco> enderecos;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_profissional")
    private List<Cidade> cidades;

    @OneToMany
    @JoinColumn(name = "profissional_id")
    private List<SolicitacaoDeServico> solicitacaoDeServicos;

    public String getDataNascimento() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataNascimento);
    }
}