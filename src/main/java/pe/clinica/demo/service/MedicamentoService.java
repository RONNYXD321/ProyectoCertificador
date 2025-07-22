package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.MedicamentoModel;
import pe.clinica.demo.repository.MedicamentoRepository;
import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    // Listar todos los medicamentos
    public List<MedicamentoModel> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    // Buscar medicamento por ID
    public MedicamentoModel getMedicamentoById(Integer id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar medicamento
    public MedicamentoModel saveMedicamento(MedicamentoModel medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    // Eliminar medicamento
    public void deleteMedicamento(Integer id) {
        medicamentoRepository.deleteById(id);
    }
}