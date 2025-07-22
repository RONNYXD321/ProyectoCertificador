package pe.clinica.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.CitaModel;
import pe.clinica.demo.model.FacturacionModel;
import pe.clinica.demo.model.MedicoModel;
import pe.clinica.demo.model.PacienteModel;
import pe.clinica.demo.service.CitaService;
import pe.clinica.demo.service.MedicoService;
import pe.clinica.demo.service.PacienteService;

@Controller
@RequestMapping("/cita")
public class citaController {

    private final CitaService citaService;
    @Autowired
    private final PacienteService pacienteService;
    private final MedicoService medicoService;

    public citaController(CitaService citaService, PacienteService pacienteService, MedicoService medicoService) {
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    @GetMapping

    public String index(Model model) {
        model.addAttribute("citas",
                citaService.obtenerCitas());
        model.addAttribute("pacientes",
                pacienteService.obtenerPacientes());
        model.addAttribute("medico",
                medicoService.obtenerMedicos());
        return "cita/cita";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cita",
                new CitaModel());
        return "category/cita";
    }

    //localhost:8080/category/edit/1
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        CitaModel citaModel = citaService.obtenerCitaXid(id);

        if (citaModel == null) {
            return "redirect:/cita";
        }

        model.addAttribute("cita", citaModel);
        model.addAttribute("pacientes", pacienteService.obtenerPacientes());
        model.addAttribute("medicos", medicoService.obtenerMedicos());
        return "cita/edit";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("cita") CitaModel citaModel) {
        Integer idPaciente = citaModel.getPaciente() != null ? citaModel.getPaciente().getIdpaciente() : null;
        if (idPaciente != null) {
            PacienteModel paciente = pacienteService.obtenerPacienteXid(idPaciente);
            citaModel.setPaciente(paciente);
        }

        Integer idMedico = citaModel.getMedico() != null ? citaModel.getMedico().getIdmedico() : null;
        if (idMedico != null) {
            MedicoModel medico = medicoService.obtenerMedicoXid(idMedico);
            citaModel.setMedico(medico);
        }

        citaService.guardarCita(citaModel);
        return "redirect:/cita?success=save";  // ✅ Redirige con parámetro success=save
    }

    @PostMapping("/delete/{id}")
    public String deleteCita(@PathVariable("id") Long id) {
        citaService.eliminarCita(Math.toIntExact(id));
        return "redirect:/cita?success=delete";


    }
}


