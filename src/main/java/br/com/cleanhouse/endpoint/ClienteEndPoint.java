package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.model.Cliente;
import br.com.cleanhouse.model.Endereco;
import br.com.cleanhouse.model.Residencia;
import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.EnderecoRepository;
import br.com.cleanhouse.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(END_POINT)
    public ResponseEntity<?> getClientes(){
        return new ResponseEntity<>(clienteDAO.findAll(), HttpStatus.OK);
    }



    @GetMapping(END_POINT+"/{id}")
    public ResponseEntity<?> getCliente(@PathVariable("id") Long id){
        return new ResponseEntity<>(clienteDAO.findById(id), HttpStatus.OK);
    }


    @PostMapping(END_POINT)
    public ResponseEntity<?> setCliente( @Valid @RequestBody Cliente cliente){
        List<Residencia> residencias = cliente.getResidencias();
        residencias.forEach(residencia ->{enderecoDAO.save(residencia.getEndereco()); residenciaDAO.save(residencia);});
        //clienteDAO.save(cliente);
        return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.CREATED);
    }


    @PutMapping(END_POINT)
    public ResponseEntity<?> atualizaCliente(@Valid @RequestBody Cliente  cliente){
        verificaExistenciaIdCliente(cliente.getId());
        List<Residencia> residencias = cliente.getResidencias();
        residencias.forEach(residencia ->{enderecoDAO.save(residencia.getEndereco()); residenciaDAO.save(residencia);});
        return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.OK);
    }


    @DeleteMapping(END_POINT+"/{id}")
    public ResponseEntity<?> deletaCliente(@PathVariable("id")  Long id){
        verificaExistenciaIdCliente(id);
        clienteDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private void verificaExistenciaIdCliente(Long id){
        //verifica se existe profissional com o id informado
        if( ! clienteDAO.findById(id).isPresent() ){
            throw new ResourceNotFoundException("profissional nao encontrado pelo id: "+id);
        }
    }
}
