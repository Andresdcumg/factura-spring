package com.wtorresd1.Facturass.repository;

import org.springframework.stereotype.Repository;
import com.wtorresd1.Facturass.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
}