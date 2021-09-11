package com.wtorresd1.Facturass.repository;

import com.wtorresd1.Facturass.model.Producto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}