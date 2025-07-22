package pe.clinica.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.clinica.demo.model.AdministrativoModel;
import pe.clinica.demo.repository.AdministrativoRepository;
import pe.clinica.demo.service.AdministrativoService;

import java.util.List;

@Controller
@RequestMapping("/administrativo")
public class AdministrativoController {

    private final AdministrativoService administrativoService;

    public AdministrativoController(AdministrativoService administrativoService) {
        this.administrativoService = administrativoService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("administrativos", administrativoService.obtenerAdministartivo());
        model.addAttribute("administrativo", new AdministrativoModel()); // <- esto faltaba
        return "administrativo/administrativo";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("administrativo",
                new AdministrativoModel());
        return "administrativo/create";
    }

    //localhost:8080/category/edit/1
    @GetMapping("/edit/{id}")
    public String edit(Model model,
                       @PathVariable int id){
        model.addAttribute("administrativo",
                administrativoService.obtenerAdministrativoXid(id));
        return "administrativo/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("administrativo") AdministrativoModel administrativoModel) {
        administrativoService.guardarAdministrativos(administrativoModel);
        return "redirect:/administrativo";
    }

    @PostMapping("/delete/{id}")
    public String deleteAdministrativo(@PathVariable("id") Long id) {
        administrativoService.eliminarAdministrativo(Math.toIntExact(id));
        return "redirect:/administrativo";
    }





}

