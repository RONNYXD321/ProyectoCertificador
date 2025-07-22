package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.DetalleModel;

public interface DetalleRepository extends JpaRepository <DetalleModel, Integer> {
}
