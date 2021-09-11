package com.wtorresd1.Facturass.model;

import java.util.Date;
import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "producto")
@EntityListeners(AuditingEntityListener.class)
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProducto;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "vence", nullable = false)
    private Date vence;

    @Column(name = "lote", nullable = false)
    private String lote;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public long getId() {
        return idProducto;
    }

    public void setId(long id) {
        this.idProducto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getVence() {
        return vence;
    }

    public void setVence(Date vence) {
        this.vence = vence;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}