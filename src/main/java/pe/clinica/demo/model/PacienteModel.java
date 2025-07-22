package pe.clinica.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "paciente")

public class    PacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpaciente;
    private Integer dnipaciente;
    private String nombresapellidos;
    private LocalDate fechanacimiento;
    private Integer telefono;
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNombresapellidos() {
        return nombresapellidos;
    }

    public void setNombresapellidos(String nombresapellidos) {
        this.nombresapellidos = nombresapellidos;
    }

    public Integer getDnipaciente() {
        return dnipaciente;
    }

    public void setDnipaciente(Integer dnipaciente) {
        this.dnipaciente = dnipaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }
}