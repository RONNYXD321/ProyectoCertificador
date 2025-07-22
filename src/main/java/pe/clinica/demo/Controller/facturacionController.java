package pe.clinica.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.AdministrativoModel;
import pe.clinica.demo.model.FacturacionModel;
import pe.clinica.demo.model.PacienteModel;
import pe.clinica.demo.service.AdministrativoService;
import pe.clinica.demo.service.FacturacionService;
import pe.clinica.demo.service.PacienteService;

@Controller
@RequestMapping("/facturacion")
public class facturacionController {
    private final FacturacionService facturacionService;
    @Autowired
    private final PacienteService pacienteService;
    @Autowired
    private final AdministrativoService administrativoService;

    public facturacionController(FacturacionService facturacionService, PacienteService pacienteService, AdministrativoService administrativoService) {
        this.facturacionService = facturacionService;
        this.pacienteService = pacienteService;
        this.administrativoService = administrativoService;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("facturacion", new FacturacionModel());

        model.addAttribute("facturas",
                facturacionService.obtenerFacturacion());
        model.addAttribute("pacientes",
                pacienteService.obtenerPacientes()); // <-- Asegúrate de esto
        model.addAttribute("administrativos",
                administrativoService.obtenerAdministartivo()); // <-- También esto
        return "facturacion/facturacion";
    }
    @GetMapping("/create")
    public String create (Model model) {
        model.addAttribute("facturacion",
                new FacturacionModel());
        return "facturacion/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        // 1. Obtener la factura existente
        FacturacionModel factura = facturacionService.obtenerFacturacionXid(id);

        // 2. Verificar si existe
        if (factura == null) {
            return "redirect:/facturacion";
        }

        // 3. Cargar datos necesarios para los dropdowns
        model.addAttribute("facturacion", factura);
        model.addAttribute("pacientes", pacienteService.obtenerPacientes());
        model.addAttribute("administrativos", administrativoService.obtenerAdministartivo());

        return "facturacion/edit";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("facturacion") FacturacionModel facturacionModel) {
        // Obtener los IDs del modelo (si los campos en el formulario tienen el mismo nombre que en el modelo)
        Integer idPaciente = facturacionModel.getPaciente() != null ? facturacionModel.getPaciente().getIdpaciente() : null;
        Integer idAdministrativo = facturacionModel.getAdministrativo() != null ? facturacionModel.getAdministrativo().getIdadministrativo() : null;

        // Buscar y asignar los objetos
        if (idPaciente != null) {
            PacienteModel paciente = pacienteService.obtenerPacienteXid(idPaciente);
            facturacionModel.setPaciente(paciente);
        }
        if (idAdministrativo != null) {
            AdministrativoModel administrativo = administrativoService.obtenerAdministrativoXid(idAdministrativo);
            facturacionModel.setAdministrativo(administrativo);
        }

        facturacionService.guardarFacturacion(facturacionModel);
        return "redirect:/facturacion";
    }
    @PostMapping("/delete/{id}")
    public String deleteFacturacion(@PathVariable("id") Long id) {
        facturacionService.eliminarFacturacion(Math.toIntExact(id));
        return "redirect:/facturacion";
    }


}



