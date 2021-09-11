package com.wtorresd1.Facturass.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "detalleFactura")
@EntityListeners(AuditingEntityListener.class)
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDetFact;

    @Column(name = "idProducto", nullable = false)
    private long idProducto;

    @Column(name = "idFactura", nullable = false)
    private long idFactura;

    @Column(name = "producto", nullable = false)
    private String producto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public long getId() {
        return idDetFact;
    }

    public void setId(long id) {
        this.idDetFact = id;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public String getProducto() {
        return producto;
    }

    public void setproducto(String producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}