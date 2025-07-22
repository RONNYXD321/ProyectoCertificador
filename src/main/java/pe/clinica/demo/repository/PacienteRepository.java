package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.PacienteModel;

public interface PacienteRepository extends JpaRepository <PacienteModel,Integer> {
}
