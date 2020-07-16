package br.com.cleanhouse.endpoint;

import br.com.cleanhouse.model.*;
import br.com.cleanhouse.repository.*;
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
    private ResidenciaRepository residenciaDAO;

    @Autowired
    private ServicoRepository servicoDAO;

    @PostMapping("servico")
    public ResponseEntity<?> servico(@Valid @RequestBody SolicitacaoDeServicoDTO solicitacaoDeServicoDTO){

        Long idCliente = solicitacaoDeServicoDTO.getIdCliente();
        Long idProfissional = solicitacaoDeServicoDTO.getIdProfissional();
        Long idResidencia = solicitacaoDeServicoDTO.getResidencia().getId();

        solicitacaoDeServicoDTO.setResidencia(residenciaDAO.findById(idResidencia).get());

        Servico servico = servicoDAO.save(solicitacaoDeServicoDTO.getServicos());

        solicitacaoDeServicoDTO.setServicos(servico);

        System.out.println(servico);

        SolicitacaoDeServico solicitacaoDeServico = new SolicitacaoDeServico();

        solicitacaoDeServico.setServicos(servico);
        solicitacaoDeServico.setData(solicitacaoDeServicoDTO.getData());
        solicitacaoDeServico.setResidencia(solicitacaoDeServicoDTO.getResidencia());
        solicitacaoDeServico.setObservacao(solicitacaoDeServicoDTO.getObservacao());
        solicitacaoDeServico.setPreco(solicitacaoDeServicoDTO.getPreco());
        solicitacaoDeServico.setStatus(solicitacaoDeServicoDTO.getStatus());

        List<SolicitacaoDeServico> listSolicitacaoDeServicos = new ArrayList<>();
        listSolicitacaoDeServicos.add(solicitacaoDeServico);

        System.out.println(solicitacaoDeServico);
        System.out.println(listSolicitacaoDeServicos);

        Cliente cliente = clienteDAO.findById(idCliente).get();
        Profissional profissional = profissionalDAO.findById(idProfissional).get();

        cliente.setSolicitacaoDeServicos(listSolicitacaoDeServicos);
        profissional.setSolicitacaoDeServicos(listSolicitacaoDeServicos);

        solicitacaoDeServicoDTO.setCliente(cliente.getNomeCompleto());
        solicitacaoDeServicoDTO.setProfissional(profissional.getNomeCompleto());

        System.out.println(solicitacaoDeServicoDTO);
        System.out.println(solicitacaoDeServicoDTO.getResidencia().getId());

        try {
            solicitacaoDAO.save(solicitacaoDeServico);
        }catch (Exception e){
            e.printStackTrace();
        }



        return new ResponseEntity<>(solicitacaoDeServicoDTO, HttpStatus.CREATED);

    }

}
