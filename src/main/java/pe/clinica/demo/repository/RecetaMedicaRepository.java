package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.RecetaMedicaModel;

public interface RecetaMedicaRepository extends JpaRepository <RecetaMedicaModel,Integer> {
}
