package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.EspecialidadModel;

public interface EspecialidadRepository extends JpaRepository <EspecialidadModel, Integer> {
}
