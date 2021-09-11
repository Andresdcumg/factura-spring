package com.wtorresd1.Facturass.model;

import javax.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Idcliente;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nit", nullable = false)
    private Integer nit;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    public long getId() {
        return Idcliente;
    }

    public void setId(long id) {
        this.Idcliente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}