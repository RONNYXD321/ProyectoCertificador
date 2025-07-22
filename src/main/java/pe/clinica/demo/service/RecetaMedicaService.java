package pe.clinica.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.clinica.demo.model.RecetaMedicaModel;
import pe.clinica.demo.repository.RecetaMedicaRepository;

import java.util.List;
@Service
public class RecetaMedicaService {
    private final RecetaMedicaRepository recetaMedicaRepository;

    @Autowired
    public RecetaMedicaService(RecetaMedicaRepository recetaMedicaRepository) {
        this.recetaMedicaRepository = recetaMedicaRepository;
    }

    public List<RecetaMedicaModel> obtenerRecetasMedicas() {
        return recetaMedicaRepository.findAll();
    }

    public RecetaMedicaModel obtenerRecetaMedicaXid(Integer id) {
        return recetaMedicaRepository.findById(id).orElse(null);
    }

    public void guardarRecetaMedica(RecetaMedicaModel model) {
        recetaMedicaRepository.save(model);
    }

    public void eliminarRecetaMedica(Integer id) {
        recetaMedicaRepository.deleteById(id);
    }
}