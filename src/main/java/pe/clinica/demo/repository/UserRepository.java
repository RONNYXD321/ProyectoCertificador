package pe.clinica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.clinica.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Busca por el nombre de usuario
}