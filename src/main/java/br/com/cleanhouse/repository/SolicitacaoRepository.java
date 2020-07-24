package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Cliente;
import br.com.cleanhouse.model.SolicitacaoDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoDeServico, Long> {

    List<SolicitacaoDeServico> findByCliente(Cliente cliente);
}
