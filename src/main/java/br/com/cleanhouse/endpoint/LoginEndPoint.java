package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.model.*;
import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.ProfissionalRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("login")
public class LoginEndPoint {

    @Autowired
    private UsuarioRepository usuarioDAO;

    @Autowired
    private ClienteRepository clienteDAO;

    @Autowired
    private ProfissionalRepository profissionalDAO;

    @PostMapping("usuario")
    public ResponseEntity<?> findUsuario(@Valid @RequestBody Usuario usuario){


        if(usuarioDAO.existsByEmailAndSenha(usuario.getEmail(), usuario.getSenha())){

            Usuario user = usuarioDAO.findByEmail(usuario.getEmail());
            if(usuarioDAO.findByEmail(usuario.getEmail()).getTipo().equals("cliente")){

                return ResponseEntity.ok().body(clienteDAO.findByUsuario(user));
            }
            else if(usuarioDAO.findByEmail(usuario.getEmail()).getTipo().equals("profissional")){

                return ResponseEntity.ok().body(profissionalDAO.findByUsuario(user));
            }
            return ResponseEntity.ok().body("Não tem tipo : " + usuarioDAO.findByEmail(usuario.getEmail()).getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou Senha incorretos!");
    }



}
