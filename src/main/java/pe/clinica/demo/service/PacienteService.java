package pe.clinica.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.clinica.demo.model.PacienteModel;
import pe.clinica.demo.repository.CitaRepository;
import pe.clinica.demo.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final CitaRepository citaRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, CitaRepository citaRepository) {
        this.pacienteRepository = pacienteRepository;
        this.citaRepository = citaRepository;
    }

    public List<PacienteModel> obtenerPacientes() {
        return pacienteRepository.findAll();
    }

    public PacienteModel obtenerPacienteXid(int id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    public void guardarPaciente(PacienteModel pacienteModel) {
        pacienteRepository.save(pacienteModel);
    }

    public void eliminarPaciente(int id) {
        // Primero eliminar las citas asociadas al paciente
        citaRepository.eliminarPorIdPaciente(id);

        // Luego eliminar el paciente
        pacienteRepository.deleteById(id);
    }
}
