package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.clinica.demo.model.AdministrativoModel;

import java.util.List;

@Repository
public interface AdministrativoRepository extends JpaRepository<AdministrativoModel, Long> {
    // Método para buscar administrativos por cargo
    List<AdministrativoModel> findByCargo(String cargo);

    // Método para buscar administrativos por correo
    AdministrativoModel findByCorreo(String correo);
}