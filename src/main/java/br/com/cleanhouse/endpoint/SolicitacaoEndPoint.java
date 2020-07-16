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
        System.out.println("-=-sddssd-=-=-=sd-=-f=ds-");
        solicitacaoDeServicoDTO.setResidencia(residenciaDAO.findById(idResidencia).get());

        System.out.println("-=-sddssd-=-=-=sd-=-f=ds-");
        Servico servico = servicoDAO.save(solicitacaoDeServicoDTO.getServicos());

        solicitacaoDeServicoDTO.setServicos(servico);

        System.out.println(servico);

        SolicitacaoDeServico solicitacaoDeServico = new SolicitacaoDeServico();

        solicitacaoDeServico.setServicos(servico);
//        solicitacaoDeServico.setData(solicitacaoDeServicoDTO.getData());
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
        System.out.println("-=-=--=-=-=--=-=--=-=-=-=-=-=-");

//        System.out.println(solicitacaoDeServicoDTO.getData());
        System.out.println("-=-=--=-=-=--=-=--=-=-=-=-=-=-");
        cliente.setSolicitacaoDeServicos(listSolicitacaoDeServicos);
        profissional.setSolicitacaoDeServicos(listSolicitacaoDeServicos);

//        clienteDAO.save(cliente);
//        profissionalDAO.save(profissional);
        solicitacaoDeServicoDTO.setCliente(cliente.getNomeCompleto());
        solicitacaoDeServicoDTO.setProfissional(profissional.getNomeCompleto());

        System.out.println(solicitacaoDeServicoDTO);
        System.out.println("antes deo savleeeeeeeee");
        System.out.println(solicitacaoDeServico);
        System.out.println("antes deo savleeeeeeeee22222222222");
        System.out.println(solicitacaoDeServico.getResidencia().getId());

        try {
            solicitacaoDeServicoDTO.setId(solicitacaoDAO.save(solicitacaoDeServico).getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(solicitacaoDeServicoDTO, HttpStatus.CREATED);
    }


}
