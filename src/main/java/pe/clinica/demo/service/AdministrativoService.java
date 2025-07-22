package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.AdministrativoModel;
import pe.clinica.demo.model.CitaModel;
import pe.clinica.demo.repository.AdministrativoRepository;
import java.util.List;
import java.util.function.Supplier;

@Service
public class AdministrativoService {
    private  final AdministrativoRepository administrativoRepository;


    public AdministrativoService(AdministrativoRepository administrativoRepository) {
        this.administrativoRepository = administrativoRepository;
    }
    public List <AdministrativoModel>obtenerAdministartivo(){
        return administrativoRepository.findAll();}

    public AdministrativoModel obtenerAdministrativoXid(int id){
        return  administrativoRepository.findById((long) id).orElse(null);
    }

    public  void guardarAdministrativos(AdministrativoModel administrativoModel){
        administrativoRepository.save(administrativoModel);
    }
    // Método para eliminar un administrativo
    public void eliminarAdministrativo(int id) {
        administrativoRepository.deleteById((long) id);
    }

}
