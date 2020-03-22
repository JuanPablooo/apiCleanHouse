package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.model.Profissional;
import br.com.cleanhouse.repository.EnderecoRepository;
import br.com.cleanhouse.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class ProfissionalEndPoint {
    private final String END_POINT = "profissionais";


    @Autowired
    private ProfissionalRepository profissionalDAO;

    @Autowired
    private EnderecoRepository enderecoDAO;

    @GetMapping(END_POINT)
    public ResponseEntity<?> getProfissionais(){
        return new ResponseEntity<>(profissionalDAO.findAll(), HttpStatus.OK);
    }
    @GetMapping(END_POINT+"/{id}")
    public ResponseEntity<?> getProfissional(@PathVariable Long id){
        return new ResponseEntity<>(profissionalDAO.findById(id), HttpStatus.OK);
    }

    @PostMapping(END_POINT)
    public ResponseEntity<?> setProfissional(@Valid @RequestBody Profissional profissional){
        enderecoDAO.save(profissional.getEndereco());
        return new ResponseEntity<>(profissionalDAO.save(profissional), HttpStatus.CREATED);
    }

    @PutMapping(END_POINT)
    public ResponseEntity<?> atualizaProfissional(@Valid @RequestBody Profissional profissional){
        verificaExistenciaIdProfissional(profissional.getId());
        enderecoDAO.save(profissional.getEndereco());
        profissionalDAO.save(profissional);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(END_POINT+"/{id}")
    public ResponseEntity<?> deletaProfissional(@PathVariable Long id){
        verificaExistenciaIdProfissional(id);
        profissionalDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verificaExistenciaIdProfissional(Long id){
        //verifica se existe profissional com o id informado
        if( ! profissionalDAO.findById(id).isPresent() ){
            throw new ResourceNotFoundException("profissional nao encontrado pelo id: "+id);
        }

    }

}