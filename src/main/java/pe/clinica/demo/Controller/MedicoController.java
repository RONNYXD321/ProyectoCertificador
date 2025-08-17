package pe.clinica.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.clinica.demo.model.MedicoModel;
import pe.clinica.demo.model.EspecialidadModel;
import pe.clinica.demo.service.MedicoService;
import pe.clinica.demo.service.EspecialidadService;

@Controller
@RequestMapping("/medico")
public class MedicoController {

    private final MedicoService medicoService;
    private final EspecialidadService especialidadService;

    public MedicoController(MedicoService medicoService,
                            EspecialidadService especialidadService) {
        this.medicoService = medicoService;
        this.especialidadService = especialidadService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("medico", new MedicoModel());
        model.addAttribute("medicos", medicoService.obtenerMedicos());
        model.addAttribute("especialidades", especialidadService.obtenerDetalle());
        return "medico/medico";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("medico", new MedicoModel());
        model.addAttribute("especialidades", especialidadService.obtenerDetalle());
        return "medico/create";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id, RedirectAttributes redirectAttributes) {
        MedicoModel medico = medicoService.obtenerMedicoXid(id);
        if (medico == null) {
            redirectAttributes.addFlashAttribute("error", "Médico no encontrado");
            return "redirect:/medico";
        }
        model.addAttribute("medico", medico);
        model.addAttribute("especialidades", especialidadService.obtenerDetalle());
        return "medico/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("medico") MedicoModel medicoModel, RedirectAttributes redirectAttributes) {
        try {
            // Asignar la especialidad completa desde el ID
            if (medicoModel.getEspecialidad() != null && medicoModel.getEspecialidad().getIdespecialidad() != null) {
                EspecialidadModel especialidad = especialidadService.obtenerEspecialidadXid(
                        medicoModel.getEspecialidad().getIdespecialidad()
                );
                medicoModel.setEspecialidad(especialidad);
            }

            medicoService.guardarMedico(medicoModel);

            String mensaje = medicoModel.getIdmedico() == null ?
                    "Médico creado exitosamente" : "Médico actualizado exitosamente";
            redirectAttributes.addFlashAttribute("success", mensaje);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al guardar: " + e.getMessage());
            return "redirect:/medico" + (medicoModel.getIdmedico() == null ? "/create" : "/edit/" + medicoModel.getIdmedico());
        }
        return "redirect:/medico";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            medicoService.eliminarMedico(id);
            redirectAttributes.addFlashAttribute("success", "Médico eliminado correctamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "no puede ser eliminado por tener registros relacionados.");
        }
        return "redirect:/medico";
    }

    @PostMapping("/update/{id}")
    public String updateMedico(@PathVariable int id,
                               @ModelAttribute("medico") MedicoModel medicoModel,
                               RedirectAttributes redirectAttributes) {
        try {
            // Asignar especialidad desde el ID
            if (medicoModel.getEspecialidad() != null &&
                    medicoModel.getEspecialidad().getIdespecialidad() != null) {
                EspecialidadModel especialidad = especialidadService
                        .obtenerEspecialidadXid(medicoModel.getEspecialidad().getIdespecialidad());
                medicoModel.setEspecialidad(especialidad);
            }

            // Forzar el ID del path variable
            medicoModel.setIdmedico(id);

            medicoService.guardarMedico(medicoModel);
            redirectAttributes.addFlashAttribute("success", "Médico actualizado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar: " + e.getMessage());
            return "redirect:/medico/edit/" + id;
        }
        return "redirect:/medico";
    }
}