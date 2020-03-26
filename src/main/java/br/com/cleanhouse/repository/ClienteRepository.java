package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeCompletoIgnoreCaseContaining(String nome);

}
