package br.com.cleanhouse.model;

import lombok.Data;
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
@Data
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

    private String telefoneFixo;

    @NotNull(message = "Celular é obrigatório!")
    private String celular;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Residencia> residencias;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<SolicitacaoDeServico> solicitacaoDeServicos;

    public String getDataNascimento(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(dataNascimento);
    }

}
