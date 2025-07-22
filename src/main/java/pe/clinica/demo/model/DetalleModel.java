package pe.clinica.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle")
public class DetalleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalle;
    @ManyToOne
    @JoinColumn(name = "idreceta")
    private RecetaMedicaModel receta;
    @ManyToOne
    @JoinColumn(name = "idmedicamento")
    private MedicamentoModel medicamento;
    private Integer cantidad;
    private Integer unidad;
    private String instrucciones;
    private String dosis;

    public Integer getIddetalle() {
        return iddetalle;
    }

    public void setIddetalle(Integer iddetalle) {
        this.iddetalle = iddetalle;
    }

    public RecetaMedicaModel getReceta() {
        return receta;
    }

    public void setReceta(RecetaMedicaModel receta) {
        this.receta = receta;
    }

    public MedicamentoModel getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoModel medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
}
