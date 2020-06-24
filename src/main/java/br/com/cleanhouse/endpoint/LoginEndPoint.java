package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.TokenAuthenticationService;
import br.com.cleanhouse.model.*;
import br.com.cleanhouse.repository.ClienteRepository;
import br.com.cleanhouse.repository.ProfissionalRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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

                /*TokenAuthenticationService tokenAuthenticationService = new TokenAuthenticationService();



                Authentication authentication = TokenAuthenticationService.addAuthentication((HttpServletResponse) response, usuario.getEmail());

                SecurityContextHolder.getContext().setAuthentication(authentication);
                //filterChain.doFilter(request, response);

                )*/

                ClienteDTO dto = new ClienteDTO(clienteDAO.findByUsuario(user));

                return ResponseEntity.ok().body(dto);
            }
            else if(usuarioDAO.findByEmail(usuario.getEmail()).getTipo().equals("profissional")){

                ProfissionalDTO dto = new ProfissionalDTO(profissionalDAO.findByUsuario(user));
                return ResponseEntity.ok().body(dto);
            }
            return ResponseEntity.ok().body("Não tem tipo : " + usuarioDAO.findByEmail(usuario.getEmail()).getId());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ou Senha incorretos!");
    }



}
