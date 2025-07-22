package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.FacturacionModel;
import pe.clinica.demo.repository.FacturacionRepository;

import java.util.List;

@Service
public class FacturacionService {
    private final FacturacionRepository facturacionRepository;

    public FacturacionService(FacturacionRepository facturacionRepository) {
        this.facturacionRepository = facturacionRepository;
    }
    public List<FacturacionModel>obtenerFacturacion(){
        return facturacionRepository.findAll();}

    public FacturacionModel obtenerFacturacionXid(int id){
        return  facturacionRepository.findById(id).orElse(null);
    }

    public  void guardarFacturacion(FacturacionModel model){
        facturacionRepository.save(model);
    }

    public void eliminarFacturacion(int id) {
        facturacionRepository.deleteById((int) id);
    }
}
