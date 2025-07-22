package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.CitaModel;
import pe.clinica.demo.repository.CitaRepository;

import java.util.List;

@Service
public class CitaService {
    private final CitaRepository citaRepository;


    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    public List<CitaModel>obtenerCitas(){
        return citaRepository.findAll();
    }
    public CitaModel obtenerCitaXid(int id){
        return  citaRepository.findById(id).orElse(null);
    }
    public  void guardarCita(CitaModel citaModel){
        citaRepository.save(citaModel);
    }
    public void eliminarCita(int id) {
        citaRepository.deleteById((int) id);

    }


}
