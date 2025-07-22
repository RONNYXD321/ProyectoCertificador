package pe.clinica.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.MedicamentoModel;
import pe.clinica.demo.service.MedicamentoService;

@Controller
@RequestMapping("/medicamento")
public class medicamentoController {

    private final MedicamentoService medicamentoService;

    public medicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }


    // Mostrar lista de medicamentos
    @GetMapping
    public String listMedicamentos(Model model) {
        model.addAttribute("medicamentos", medicamentoService.getAllMedicamentos());
        model.addAttribute("medicamento", new MedicamentoModel()); // Añade esta línea
        return "medicamento/list";
    }

    // Mostrar formulario de creación
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("medicamento", new MedicamentoModel());
        return "medicamento/form";
    }

    // Procesar formulario
    @PostMapping("/save")
    public String saveMedicamento(@ModelAttribute MedicamentoModel medicamento) {
        medicamentoService.saveMedicamento(medicamento);
        return "redirect:/medicamento";
    }

    // Eliminar medicamento
    @GetMapping("/delete/{id}")
    public String deleteMedicamento(@PathVariable Integer id) {
        medicamentoService.deleteMedicamento(id);
        return "redirect:/medicamento";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        MedicamentoModel medicamento = medicamentoService.getMedicamentoById(id);
        model.addAttribute("medicamento", medicamento);
        return "medicamento/form"; // Reutiliza la misma vista de creación
    }

    @PostMapping("/edit/{id}")
    public String updateMedicamento(@PathVariable Integer id, @ModelAttribute MedicamentoModel medicamento) {
        medicamento.setIdmedicamento(id);
        medicamentoService.saveMedicamento(medicamento);
        return "redirect:/medicamento";
    }
}