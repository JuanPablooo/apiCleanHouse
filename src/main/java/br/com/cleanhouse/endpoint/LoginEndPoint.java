package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("login")
public class LoginEndPoint {


    @Autowired
    private UsuarioRepository usuarioDAO;

    @PostMapping("usuario")
    public ResponseEntity<?> findUsuario(@Valid @RequestBody Usuario usuario){
        if(usuarioDAO.existsByEmailAndSenha(usuario.getEmail(), usuario.getSenha())){

        }
    }


}
