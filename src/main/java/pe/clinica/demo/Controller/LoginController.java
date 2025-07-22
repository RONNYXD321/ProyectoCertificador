package pe.clinica.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pe.clinica.demo.model.User;
import pe.clinica.demo.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Vista de login
    }

    @PostMapping("/login")
    public String loginUser(User user, Model model) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Vista de registro
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        // Validación: Verifica si el username ya existe
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            model.addAttribute("error", "Este usuario ya se encuentra registrado");

            return "register"; // Retorna al formulario con mensaje de error
        }

        // Guarda el nuevo usuario
        userRepository.save(user);
        return "redirect:/login";
    }
}
