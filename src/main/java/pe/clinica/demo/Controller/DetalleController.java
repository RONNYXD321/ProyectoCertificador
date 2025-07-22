package pe.clinica.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.DetalleModel;
import pe.clinica.demo.service.DetalleService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {

    private final DetalleService detalleService;

    public DetalleController(DetalleService detalleService) {
        this.detalleService = detalleService;
    }

    @GetMapping
    public String mostrarListaDetalles(Model model) {
        model.addAttribute("detalles", detalleService.obtenerDetalles());
        model.addAttribute("recetas", detalleService.obtenerRecetasParaDetalle());
        model.addAttribute("medicamentos", detalleService.obtenerMedicamentosParaDetalle());
        model.addAttribute("detalle", new DetalleModel());
        return "detalle/detalle";
    }

    @GetMapping("/create")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("detalle", new DetalleModel());
        model.addAttribute("recetas", detalleService.obtenerRecetasParaDetalle());
        model.addAttribute("medicamentos", detalleService.obtenerMedicamentosParaDetalle());
        return "detalle/edit";
    }

    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditar(@PathVariable int id, Model model) {
        DetalleModel detalle = detalleService.obtenerDetallePorId(id);
        if (detalle == null) {
            return "redirect:/detalle";
        }

        model.addAttribute("detalle", detalle);
        model.addAttribute("recetas", detalleService.obtenerRecetasParaDetalle());
        model.addAttribute("medicamentos", detalleService.obtenerMedicamentosParaDetalle());
        return "detalle/edit";
    }

    @PostMapping("/save")
    public String guardarDetalle(@ModelAttribute DetalleModel detalle) {
        detalleService.guardarDetalle(detalle);
        return "redirect:/detalle";
    }

    @PostMapping("/delete/{id}")
    public String eliminarDetalle(@PathVariable int id) {
        detalleService.eliminarDetalle(id);
        return "redirect:/detalle";
    }
}