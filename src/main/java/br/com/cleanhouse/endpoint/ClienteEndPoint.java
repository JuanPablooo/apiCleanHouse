package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.error.ResourceNotFoundException;
import br.com.cleanhouse.model.Cliente;
import br.com.cleanhouse.model.Residencia;
import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.EnderecoRepository;
import br.com.cleanhouse.repository.ResidenciaRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("v1")
public class ClienteEndPoint {
    private final String END_POINT = "clientes";

    @Autowired
    private ClienteRepository clienteDAO;

    @Autowired
    private ResidenciaRepository residenciaDAO;

    @Autowired
    private EnderecoRepository enderecoDAO;

    @Autowired
    private UsuarioRepository usuarioDAO;

    @GetMapping(END_POINT)
    public ResponseEntity<?> getClientes(){
        return new ResponseEntity<>(clienteDAO.findAll(), HttpStatus.OK);
    }



    @GetMapping(END_POINT+"/{id}")
    public ResponseEntity<?> getCliente(@PathVariable("id") Long id){
        verificaExistenciaIdCliente(id);
        return new ResponseEntity<>(clienteDAO.findById(id), HttpStatus.OK);
    }


    @PostMapping(END_POINT)
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> setCliente(@Valid @RequestBody Cliente cliente){
        salvaUsuario(cliente.getUsuario());
<<<<<<< HEAD
        @Valid
        Usuario usuario =  cliente.getUsuario();

        List<Residencia> residencias = cliente.getResidencias();
        residencias.forEach(residencia ->{enderecoDAO.save(residencia.getEndereco()); residenciaDAO.save(residencia);});
=======
        if(cliente.getResidencias() != null){
            List<Residencia> residencias = cliente.getResidencias();
            residencias.forEach(residencia ->{enderecoDAO.save(residencia.getEndereco()); residenciaDAO.save(residencia);});
        }
>>>>>>> juan
        //clienteDAO.save(cliente);
        return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.CREATED);
    }


    @PutMapping(END_POINT)
    public ResponseEntity<?> atualizaCliente(@Valid @RequestBody Cliente  cliente){
        usuarioDAO.save(cliente.getUsuario());
        verificaExistenciaIdCliente(cliente.getId());
        if(cliente.getResidencias() != null){
            List<Residencia> residencias = cliente.getResidencias();
            residencias.forEach(residencia ->{enderecoDAO.save(residencia.getEndereco()); residenciaDAO.save(residencia);});
        }
        return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.OK);
    }


    @DeleteMapping(END_POINT+"/{id}")
    public ResponseEntity<?> deletaCliente(@PathVariable Long id){
        verificaExistenciaIdCliente(id);
        clienteDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    private void verificaExistenciaIdCliente(Long id){
        //verifica se existe profissional com o id informado
        if( ! clienteDAO.findById(id).isPresent() ){
            throw new ResourceNotFoundException("cliente nao encontrado pelo id: "+id);
        }
    }
    @Transactional(rollbackFor = Exception.class)
    private void salvaUsuario(Usuario usuario){
        @Valid
        Usuario user = usuario;
        usuarioDAO.save(user);
    }

<<<<<<< HEAD
   // o @Transational nao funciona entao vou validar na mao e devolver o erro desejado

=======
    @Transactional(rollbackFor = Exception.class)
    private void salvaUsuario(Usuario usuario){
        @Valid
        Usuario user = usuario;
        user.setTipo("cliente");
        usuarioDAO.save(user);
    }
>>>>>>> juan
}

