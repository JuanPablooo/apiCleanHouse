package br.com.cleanhouse.repository;

import br.com.cleanhouse.model.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}
