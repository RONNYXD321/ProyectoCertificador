package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.FacturacionModel;

public interface FacturacionRepository  extends JpaRepository <FacturacionModel, Integer> {

}
