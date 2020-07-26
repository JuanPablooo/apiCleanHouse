package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
