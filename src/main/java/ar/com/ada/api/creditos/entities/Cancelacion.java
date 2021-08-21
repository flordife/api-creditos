package ar.com.ada.api.creditos.entities;

import java.math.BigDecimal;
import java.util.*;
import javax.persistence.*;


@Entity
public class Cancelacion {
    
    @Column(name = "cancelacion_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancelacionId;

    @ManyToOne
    @JoinColumn(name = "prestamo_id", referencedColumnName = "prestamo_id")
    private Prestamo prestamo;

    @Column(name = "fecha_cancelacion")
    private Date fechaCancelacion;

    @Column(name = "importe")
    private BigDecimal importeCuota;
    
    //Número de cuota, no el importe
    @Column(name = "cuota")
    private int numeroCuota;


    public Cancelacion(BigDecimal importeCuota, int numeroCuota, Date fechaCancelacion) {
        this.importeCuota = importeCuota;
        this.numeroCuota = numeroCuota;
        this.fechaCancelacion = fechaCancelacion;
        
    }

    public Cancelacion(){
        
    }

    public int getCancelacionId() {
        return cancelacionId;
    }

    public void setCancelacionId(int cancelacionId) {
        this.cancelacionId = cancelacionId;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
        this.prestamo.agregarCancelacion(this);
    }

    public Date getFecha_cancelacion() {
        return fechaCancelacion;
    }

    public void setFecha_cancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public BigDecimal getImporteCuota() {
        return importeCuota;
    }

    public void setImporteCuota(BigDecimal importeCuota) {
        this.importeCuota = importeCuota;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

 
}
