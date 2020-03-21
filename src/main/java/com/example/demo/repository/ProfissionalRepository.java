package com.example.demo.repository;

import com.example.demo.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    List<Profissional> findByNomeCompletoIgnoreCaseContaining(String name);
}
