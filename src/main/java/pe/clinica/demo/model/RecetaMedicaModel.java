package pe.clinica.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "recetamedica")

public class RecetaMedicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreceta;
    @ManyToOne
    @JoinColumn(name="idmedicamento")
    private MedicamentoModel medicamento;
    @ManyToOne
    @JoinColumn(name = "idmedico")
    private MedicoModel medico;
    private LocalDate fechareceta;

    public int getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(int idreceta) {
        this.idreceta = idreceta;
    }

    public MedicamentoModel getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoModel medicamento) {
        this.medicamento = medicamento;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public LocalDate getFechareceta() {
        return fechareceta;
    }

    public void setFechareceta(LocalDate fechareceta) {
        this.fechareceta = fechareceta;
    }
}