package com.wtorresd1.Facturass.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "factura")
@EntityListeners(AuditingEntityListener.class)
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFactura;

    @Column(name = "id_cliente", nullable = false)
    private long Idcliente;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "descuento", nullable = false)
    private Float descuento;

    @Column(name = "total", nullable = false)
    private Float total;

    public long getId() {
        return idFactura;
    }

    public void setId(long id) {
        this.idFactura = id;
    }

    public long getIdcliente() {
        return Idcliente;
    }

    public void setIdcliente(long idCliente) {
        this.Idcliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}