package pe.clinica.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "facturacion")

public class FacturacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idfacturacion;
    @ManyToOne
    @JoinColumn(name = "idpaciente")
    private PacienteModel paciente;
    @ManyToOne
    @JoinColumn(name = "idadministrativo")
    private AdministrativoModel administrativo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechafacturacion;
    private Double monto;
    private String estadopago;

    public Integer getIdfacturacion() {
        return idfacturacion;
    }

    public void setIdfacturacion(Integer idfacturacion) {
        this.idfacturacion = idfacturacion;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public AdministrativoModel getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(AdministrativoModel administrativo) {
        this.administrativo = administrativo;
    }

    public Date getFechafacturacion() {
        return fechafacturacion;
    }

    public void setFechafacturacion(Date fechafacturacion) {
        this.fechafacturacion = fechafacturacion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(String estadopago) {
        this.estadopago = estadopago;
    }
}
