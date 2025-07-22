package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.Historia_medicaModel;
import pe.clinica.demo.repository.HistoriaMedicaRepository;

import java.util.List;

@Service
public class HistoriaMedicaService {

    private final HistoriaMedicaRepository historiaMedicaRepository;

    public HistoriaMedicaService(HistoriaMedicaRepository historiaMedicaRepository) {
        this.historiaMedicaRepository = historiaMedicaRepository;
    }

    public List<Historia_medicaModel> obtenerHistorias() {
        return historiaMedicaRepository.findAll();
    }

    public Historia_medicaModel obtenerHistoriaPorId(int id) {
        return historiaMedicaRepository.findById(id).orElse(null);
    }

    public void guardarHistoria(Historia_medicaModel historia) {
        historiaMedicaRepository.save(historia);
    }
}
