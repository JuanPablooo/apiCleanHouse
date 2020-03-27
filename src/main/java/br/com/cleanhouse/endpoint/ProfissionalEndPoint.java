package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.error.ResourceNotFoundDetails;
import br.com.cleanhouse.model.Endereco;
import br.com.cleanhouse.model.Profissional;
import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.EnderecoRepository;
import br.com.cleanhouse.repository.ProfissionalRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import jdk.internal.reflect.CallerSensitive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1")
public class ProfissionalEndPoint {
    private final String END_POINT = "profissionais";


    @Autowired
    private ProfissionalRepository profissionalDAO;

    @Autowired
    private EnderecoRepository enderecoDAO;

    @Autowired
    private UsuarioRepository usuarioDAO;

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
        @Valid
        Usuario usuario = profissional.getUsuario();

        usuarioDAO.save(usuario);
        salvaEnderecos(profissional.getEnderecos());
        return new ResponseEntity<>(profissionalDAO.save(profissional), HttpStatus.CREATED);
    }

    @PutMapping(END_POINT)
    public ResponseEntity<?> atualizaProfissional(@Valid @RequestBody Profissional profissional){
        @Valid
        Usuario usuario = profissional.getUsuario();
        verificaExistenciaIdUsuario(usuario.getId());
        usuarioDAO.save(usuario);
        verificaExistenciaIdProfissional(profissional.getId());
        salvaEnderecos(profissional.getEnderecos());
        profissionalDAO.save(profissional);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(END_POINT+"/{id}")
    public ResponseEntity<?> deletaProfissional(@PathVariable Long id){
        verificaExistenciaIdProfissional(id);
        profissionalDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //verifica se existe profissional, caso nao exita lanca uma execao na requisicao
    private void verificaExistenciaIdProfissional(Long id){
        if( ! profissionalDAO.findById(id).isPresent() ){
            throw new ResourceNotFoundException("profissional nao encontrado pelo id: "+id);
        }
    }

    private void verificaExistenciaIdUsuario(Long id){
        if( ! usuarioDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("usuario nao encontrado pelo id:"+id);
        }
    }

    private void salvaEnderecos(List<Endereco> enderecos){
        enderecos.forEach(  endereco ->{
            @Valid
            Endereco endereco1 = endereco;
            enderecoDAO.save(endereco1);
        });
    }
    @Transactional(rollbackFor = Exception.class)
    private void salvaUsuario(Usuario usuario){
        @Valid
        Usuario user = usuario;
        usuarioDAO.save(user);
    }

}
