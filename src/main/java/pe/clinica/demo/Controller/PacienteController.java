package pe.clinica.demo.Controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.PacienteModel;
import pe.clinica.demo.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String index(Model model, @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("pacientes", pacienteService.obtenerPacientes());
        if (error != null) {
            model.addAttribute("errorMensaje", "No se puede eliminar este paciente porque tiene registros relacionados.");
        }
        return "paciente/paciente";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("paciente", new PacienteModel());
        return "paciente/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("paciente", pacienteService.obtenerPacienteXid(id));
        return "paciente/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("paciente") PacienteModel pacienteModel) {
        pacienteService.guardarPaciente(pacienteModel);
        return "redirect:/paciente";
    }

    @PostMapping("/delete/{id}")
    public String deletePaciente(@PathVariable("id") Long id) {
        try {
            pacienteService.eliminarPaciente(Math.toIntExact(id));
        } catch (DataIntegrityViolationException e) {
            return "redirect:/paciente?error=true";
        }
        return "redirect:/paciente";
    }
}
