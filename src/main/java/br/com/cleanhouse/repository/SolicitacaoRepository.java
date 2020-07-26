package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.SolicitacaoDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<SolicitacaoDeServico, Long> {

    SolicitacaoDeServico findByCliente(Long cliente_id);
//    SolicitacaoDeServico findById(Long id);
}
