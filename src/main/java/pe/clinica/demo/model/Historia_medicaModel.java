package pe.clinica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historiamedica")

public class Historia_medicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhistoria;
    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private PacienteModel paciente;
    private String diagnostico;
    private String fecha;
    private String tratamiento;

    public Integer getIdhistoria() {
        return idhistoria;
    }

    public void setIdhistoria(Integer idhistoria) {
        this.idhistoria = idhistoria;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}
