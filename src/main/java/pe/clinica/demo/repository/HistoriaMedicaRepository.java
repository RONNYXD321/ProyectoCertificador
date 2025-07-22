package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.Historia_medicaModel;

public interface HistoriaMedicaRepository extends JpaRepository<Historia_medicaModel, Integer> {
}