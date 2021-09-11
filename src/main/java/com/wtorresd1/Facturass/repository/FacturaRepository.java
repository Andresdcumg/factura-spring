package com.wtorresd1.Facturass.repository;

import com.wtorresd1.Facturass.model.Factura;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}