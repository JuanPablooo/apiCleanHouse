package br.com.cleanhouse.endpoint;

import br.com.cleanhouse.model.Cliente;
import br.com.cleanhouse.model.Endereco;
import br.com.cleanhouse.model.Profissional;
import br.com.cleanhouse.model.SolicitacaoDeServico;
import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.EnderecoRepository;
import br.com.cleanhouse.repository.ProfissionalRepository;
import br.com.cleanhouse.repository.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("solicitacao")
public class SolicitacaoEndPoint {

    @Autowired
    private SolicitacaoRepository solicitacaoDAO;

    @Autowired
    private ClienteRepository clienteDAO;

    @Autowired
    private ProfissionalRepository profissionalDAO;

    @Autowired
    private EnderecoRepository enderecoDAO;

    @PostMapping("servico")
    public ResponseEntity<?> servico(@RequestBody SolicitacaoDeServico solicitacaoDeServico, Long idCliente){

        //Long idCliente = solicitacaoDeServico.getCliente().getId();
        //Long idProfissional = solicitacaoDeServico.getProfissional().getId();

        System.out.println(idCliente);
        System.out.println(solicitacaoDeServico);

        /*@Valid
        Cliente cliente = solicitacaoDeServico.getCliente();

        @Valid
        Profissional profissional = solicitacaoDeServico.getProfissional();*/

        return new ResponseEntity<>("Ok", HttpStatus.CREATED);

    }

}
