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

    private Long idCliente;
    private Long idProfissional;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    @JsonIgnore
    private Profissional profissional;

    @Temporal(TemporalType.DATE)
    private Date data;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Servico servicos;

    private double preco;

    private String observacao;

    private String status;

    public String getData() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(data);
    }

}
