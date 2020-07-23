package br.com.cleanhouse.endpoint;

import br.com.cleanhouse.model.*;
import br.com.cleanhouse.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private ResidenciaRepository residenciaDAO;

    @Autowired
    private ServicoRepository servicoDAO;


    @PostMapping(value = "servico")
    public ResponseEntity<?> servico(@RequestBody SolicitacaoDeServicoDTO solicitacaoDeServicoDTO){
        //pegando dados por meio dos ids informados
        Cliente cliente = clienteDAO.findById(solicitacaoDeServicoDTO.getIdCliente()).get();
        Residencia residencia = residenciaDAO.findById(solicitacaoDeServicoDTO.getResidencia().getId()).get();
        Profissional profissional = profissionalDAO.findById(solicitacaoDeServicoDTO.getIdProfissional()).get();

        Servico servicos = solicitacaoDeServicoDTO.getServicos();

        servicoDAO.save(servicos);

        //criando e inserindo dados recebidos no objeto que ira ser salvo
        SolicitacaoDeServico solicitacaoDeServico = new SolicitacaoDeServico();
        solicitacaoDeServico.setProfissional(profissional);
        solicitacaoDeServico.setCliente(cliente);
        solicitacaoDeServico.setServicos(servicos);
        solicitacaoDeServico.setObservacao(solicitacaoDeServicoDTO.getObservacao());
        solicitacaoDeServico.setPreco(solicitacaoDeServicoDTO.getPreco());
        solicitacaoDeServico.setStatus(solicitacaoDeServicoDTO.getStatus());
        solicitacaoDeServico.setResidencia(residencia);
        solicitacaoDeServico.setData(solicitacaoDeServicoDTO.getData());
        solicitacaoDeServico.setIdC(cliente.getId());
        solicitacaoDeServico.setIdP(profissional.getId());
        //salvando objeto criado no banco
        SolicitacaoDeServico solicitacaoDeServicoSalvado = solicitacaoDAO.save(solicitacaoDeServico);
        // adicionando nome e objetos com seus respectivos Ids no objeto que sera devolvido ao front
        solicitacaoDeServicoDTO.setResidencia(residencia);
        solicitacaoDeServicoDTO.setId(solicitacaoDeServicoSalvado.getId());
        solicitacaoDeServicoDTO.setProfissional(profissional.getNomeCompleto());
        solicitacaoDeServicoDTO.setCliente(cliente.getNomeCompleto());
        return new ResponseEntity<>( solicitacaoDeServicoDTO, HttpStatus.CREATED);
    }


}
