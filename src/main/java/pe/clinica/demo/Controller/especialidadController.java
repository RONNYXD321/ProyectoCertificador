package pe.clinica.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.clinica.demo.model.EspecialidadModel;
import pe.clinica.demo.service.EspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class especialidadController {
    private final EspecialidadService especialidadService;
    public especialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }
    // Vista principal (listar + formulario de creación)
    @GetMapping
    public String index(Model model) {
        model.addAttribute("especialidades", especialidadService.obtenerDetalle());
        model.addAttribute("especialidad", new EspecialidadModel()); // Para el formulario de creación
        return "especialidad/especialidad";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("especialidad",
                new EspecialidadModel());
        return "especialidad/create";
    }

    //localhost:8080/category/edit/1
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        EspecialidadModel especialidad = especialidadService.obtenerEspecialidadXid(id);

        if (especialidad == null) {
            throw new RuntimeException("Especialidad no encontrada para el ID: " + id);
        }

        model.addAttribute("especialidad", especialidad);
        return "especialidad/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("especialidad") EspecialidadModel especialidadModel) {
        especialidadService.guardarEspecialidad(especialidadModel);
        return "redirect:/especialidad";
    }


}


