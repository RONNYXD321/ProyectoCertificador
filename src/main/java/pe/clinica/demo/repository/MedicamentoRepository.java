package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.MedicamentoModel;

public interface MedicamentoRepository extends JpaRepository <MedicamentoModel, Integer> {
}
