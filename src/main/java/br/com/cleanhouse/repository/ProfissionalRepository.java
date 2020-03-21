package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findByNomeCompletoIgnoreCaseContaining(String name);
}
