package br.com.cleanhouse.model;

import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.SolicitacaoRepository;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tbl_solicitacao_servico")
@Data
public class SolicitacaoDeServico extends AtributosGenericos{

    @OneToOne(cascade = CascadeType.MERGE)
    private Residencia residencia;

    private boolean aprovado;

    private Long idC;
    private Long idP;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    //    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    @JsonIgnore
    private Profissional profissional;


    private Date data;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Servico servicos;

    private double preco;

    private String observacao;

    private String status;

    public String getDataNascimento() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }

    public SolicitacaoDeServico(Residencia residencia, Long idC, Long idP, Date data, Servico servicos, double preco, String observacao, String status) {
        this.residencia = residencia;
        this.idC = idC;
        this.idP = idP;
        this.data = data;
        this.servicos = servicos;
        this.preco = preco;
        this.observacao = observacao;
        this.status = status;
    }

    public SolicitacaoDeServico() {

    }
}
