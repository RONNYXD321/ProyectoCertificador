package pe.clinica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")

public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedico;
    private Integer dnimedico;
    @ManyToOne
    @JoinColumn(name="idespecialidad")
    private EspecialidadModel especialidad;
    private String nombresapellidos;
    private Integer telefono;
    private String correo;

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Integer getDnimedico() {
        return dnimedico;
    }

    public void setDnimedico(Integer dnimedico) {
        this.dnimedico = dnimedico;
    }

    public EspecialidadModel getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadModel especialidad) {
        this.especialidad = especialidad;
    }

    public String getNombresapellidos() {
        return nombresapellidos;
    }

    public void setNombresapellidos(String nombresapellidos) {
        this.nombresapellidos = nombresapellidos;
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
