package pe.clinica.demo.service;

import org.springframework.stereotype.Service;
import pe.clinica.demo.model.DetalleModel;
import pe.clinica.demo.model.MedicamentoModel;
import pe.clinica.demo.model.RecetaMedicaModel;
import pe.clinica.demo.repository.DetalleRepository;

import java.util.List;

@Service
public class DetalleService {

    private final DetalleRepository detalleRepository;
    private final RecetaMedicaService recetaMedicaService;
    private final MedicamentoService medicamentoService;

    public DetalleService(DetalleRepository detalleRepository,
                          RecetaMedicaService recetaMedicaService,
                          MedicamentoService medicamentoService) {
        this.detalleRepository = detalleRepository;
        this.recetaMedicaService = recetaMedicaService;
        this.medicamentoService = medicamentoService;
    }

    public List<DetalleModel> obtenerDetalles() {
        return detalleRepository.findAll();
    }

    public DetalleModel obtenerDetallePorId(int id) {
        return detalleRepository.findById(id).orElse(null);
    }

    public void guardarDetalle(DetalleModel detalle) {
        detalleRepository.save(detalle);
    }

    public void eliminarDetalle(int id) {
        detalleRepository.deleteById(id);
    }

    // Nuevos métodos para obtener recetas y medicamentos
    public List<RecetaMedicaModel> obtenerRecetasParaDetalle() {
        return recetaMedicaService.obtenerRecetasMedicas();
    }

    public List<MedicamentoModel> obtenerMedicamentosParaDetalle() {
        return medicamentoService.getAllMedicamentos();
    }
}