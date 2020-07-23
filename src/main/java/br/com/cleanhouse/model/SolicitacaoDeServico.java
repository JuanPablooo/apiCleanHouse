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

    /*@ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "servicos_id")

     */

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

}
