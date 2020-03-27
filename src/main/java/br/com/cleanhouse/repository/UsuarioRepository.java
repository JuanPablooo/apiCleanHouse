package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByEmailAndSenha(String email, String senha);
}
