package br.com.cleanhouse.model;

import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.SolicitacaoRepository;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tbl_solicitacao_servico")
@Data
public class SolicitacaoDeServico extends AtributosGenericos{

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;



    private Date data;
    private Integer idP;
    private Integer idC;

    @OneToOne(cascade = CascadeType.REFRESH)
    private Endereco endereco;


//    @OneToOne(cascade = CascadeType.REFRESH)
//    private Servico servicos;


    private double preco;


    private String observacao;


    private String status;

}
