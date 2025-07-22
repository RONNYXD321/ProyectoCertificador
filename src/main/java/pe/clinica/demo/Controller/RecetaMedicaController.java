package pe.clinica.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.*;
import pe.clinica.demo.service.*;


@Controller
@RequestMapping("/recetaMedica")
public class RecetaMedicaController {
    private final RecetaMedicaService recetaMedicaService;
    private final MedicoService medicoService;
    private final MedicamentoService medicamentoService;

    @Autowired
    public RecetaMedicaController(RecetaMedicaService recetaMedicaService,
                                  MedicoService medicoService,
                                  MedicamentoService medicamentoService) {
        this.recetaMedicaService = recetaMedicaService;
        this.medicoService = medicoService;
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("receta", new RecetaMedicaModel());
        model.addAttribute("recetas", recetaMedicaService.obtenerRecetasMedicas());
        model.addAttribute("medicos", medicoService.obtenerMedicos());
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        return "recetaMedica/recetaMedica";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("receta", new RecetaMedicaModel());
        model.addAttribute("medicos", medicoService.obtenerMedicos());
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        return "recetaMedica/recetaMedica";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        RecetaMedicaModel receta = recetaMedicaService.obtenerRecetaMedicaXid(id);
        if (receta == null) {
            return "redirect:/recetaMedica";
        }
        model.addAttribute("receta", receta);
        model.addAttribute("medicos", medicoService.obtenerMedicos());
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        return "recetaMedica/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("receta") RecetaMedicaModel recetaModel) {
        recetaMedicaService.guardarRecetaMedica(recetaModel);
        return "redirect:/recetaMedica";
    }

    @PostMapping("/delete/{id}")
    public String deleteRecetaMedica(@PathVariable("id") Integer id) {
        recetaMedicaService.eliminarRecetaMedica(id);
        return "redirect:/recetaMedica";
    }
}