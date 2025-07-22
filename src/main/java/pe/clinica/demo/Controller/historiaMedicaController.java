package pe.clinica.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.Historia_medicaModel;
import pe.clinica.demo.service.HistoriaMedicaService;
import pe.clinica.demo.service.PacienteService;

@Controller
@RequestMapping("/historia")
public class historiaMedicaController {
    private final HistoriaMedicaService historiaMedicaService;
    private final PacienteService pacienteService;

    public historiaMedicaController(HistoriaMedicaService historiaMedicaService, PacienteService pacienteService) {
        this.historiaMedicaService = historiaMedicaService;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("historias", historiaMedicaService.obtenerHistorias());
        model.addAttribute("historia", new Historia_medicaModel()); // <-- esto falta
        model.addAttribute("pacientes", pacienteService.obtenerPacientes());
        return "historiaMedica/historial";
    }



    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("historia", new Historia_medicaModel());
        return "historiaMedica/edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Historia_medicaModel historia = historiaMedicaService.obtenerHistoriaPorId(id);
        if (historia == null) {
            throw new RuntimeException("Historia médica no encontrada con ID: " + id);
        }

        // Agrega estos dos elementos al modelo
        model.addAttribute("historia", historia); // Usa la historia obtenida, no una nueva
        model.addAttribute("pacientes", pacienteService.obtenerPacientes()); // Lista de pacientes

        return "historiaMedica/edit";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("historia") Historia_medicaModel historia) {
        historiaMedicaService.guardarHistoria(historia);
        return "redirect:/historia"; // <- este endpoint debe estar mapeado correctamente
    }

}
