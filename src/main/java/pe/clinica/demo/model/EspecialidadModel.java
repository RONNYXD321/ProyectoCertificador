package pe.clinica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "especialidad")

public class EspecialidadModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String nombreespecialidad;
    private String descripcion;

    public Integer getIdespecialidad() {
        return idespecialidad;
    }

    public void setIdespecialidad(Integer idespecialidad) {
        this.idespecialidad = idespecialidad;
    }

    public String getNombreespecialidad() {
        return nombreespecialidad;
    }

    public void setNombreespecialidad(String nombreespecialidad) {
        this.nombreespecialidad = nombreespecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
