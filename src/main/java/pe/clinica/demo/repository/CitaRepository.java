package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pe.clinica.demo.model.CitaModel;


public interface CitaRepository extends JpaRepository<CitaModel, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM CitaModel c WHERE c.paciente.idpaciente = :id")
    void eliminarPorIdPaciente(int id);
}
