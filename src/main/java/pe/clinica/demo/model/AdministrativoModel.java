package pe.clinica.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "administrativo")


public class AdministrativoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idadministrativo;
    private String nombresapellidos;
    private String cargo;
    private Integer telefono;
    private String correo;

    public Integer getIdadministrativo() {
        return idadministrativo;
    }

    public void setIdadministrativo(Integer idadministrativo) {
        this.idadministrativo = idadministrativo;
    }

    public String getNombresapellidos() {
        return nombresapellidos;
    }

    public void setNombresapellidos(String nombresapellidos) {
        this.nombresapellidos = nombresapellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}