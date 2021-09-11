package com.wtorresd1.Facturass.controller;

import com.wtorresd1.Facturass.exception.ResourceNotFoundException;
import com.wtorresd1.Facturass.model.DetalleFactura;
import com.wtorresd1.Facturass.repository.DetalleFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/det-facturas")
    public List<DetalleFactura> getAllUsers() {
        return detalleFacturaRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/det-facturas/{id}")
    public ResponseEntity<DetalleFactura> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        DetalleFactura factura =
                detalleFacturaRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(factura);
    }

    /**
     * Create user user.
     *
     * @param producto the user
     * @return the user
     */
    @PostMapping("/det-facturas")
    public DetalleFactura createUser(@Valid @RequestBody DetalleFactura producto) {
        return detalleFacturaRepository.save(producto);
    }

    /**
     * Update user response entity.
     *
     * @param userId      the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/det-facturas/{id}")
    public ResponseEntity<DetalleFactura> updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody DetalleFactura userDetails)
            throws ResourceNotFoundException {

        DetalleFactura factura =
                detalleFacturaRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        factura.setCantidad(userDetails.getCantidad());
        factura.setproducto(userDetails.getProducto());
        final DetalleFactura updatedFactura = detalleFacturaRepository.save(factura);
        return ResponseEntity.ok(updatedFactura);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/det-facturas/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        DetalleFactura factura =
                detalleFacturaRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        detalleFacturaRepository.delete(factura);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}