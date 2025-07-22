package pe.clinica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")

public class MedicamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmedicamento;
    private String nombremedicamento;
    private String tipo;
    private String descripcion;

    public Integer getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Integer idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getNombremedicamento() {
        return nombremedicamento;
    }

    public void setNombremedicamento(String nombremedicamento) {
        this.nombremedicamento = nombremedicamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
