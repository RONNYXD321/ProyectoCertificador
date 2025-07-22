package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.DetalleModel;
import pe.clinica.demo.model.EspecialidadModel;
import pe.clinica.demo.model.MedicoModel;
import pe.clinica.demo.model.PacienteModel;
import pe.clinica.demo.repository.EspecialidadRepository;
import pe.clinica.demo.repository.MedicoRepository;

import java.util.List;

@Service
public class EspecialidadService {
    private  final EspecialidadRepository especialidadRepository;
    private final MedicoRepository medicoRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository, MedicoRepository medicoRepository) {
        this.especialidadRepository = especialidadRepository;
        this.medicoRepository = medicoRepository;
    }

    public List<EspecialidadModel> obtenerDetalle(){
        return especialidadRepository.findAll();}

    public EspecialidadModel obtenerEspecialidadXid(int id){
        return  especialidadRepository.findById(id).orElse(null);
    }
    public  void guardarEspecialidad( EspecialidadModel especialidadModel){

        especialidadRepository.save(especialidadModel);
    }

}
