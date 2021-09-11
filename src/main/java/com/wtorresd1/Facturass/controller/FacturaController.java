package com.wtorresd1.Facturass.controller;

import com.wtorresd1.Facturass.exception.ResourceNotFoundException;
import com.wtorresd1.Facturass.model.Factura;
import com.wtorresd1.Facturass.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/facturas")
    public List<Factura> getAllUsers() {
        return facturaRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/facturas/{id}")
    public ResponseEntity<Factura> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Factura factura =
                facturaRepository
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
    @PostMapping("/facturas")
    public Factura createUser(@Valid @RequestBody Factura producto) {
        return facturaRepository.save(producto);
    }

    /**
     * Update user response entity.
     *
     * @param userId      the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/facturas/{id}")
    public ResponseEntity<Factura> updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Factura userDetails)
            throws ResourceNotFoundException {

        Factura factura =
                facturaRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        factura.setIdcliente(userDetails.getIdcliente());
        factura.setNombreCliente(userDetails.getNombreCliente());
        factura.setDireccion(userDetails.getDireccion());
        factura.setCantidad(userDetails.getCantidad());
        factura.setDescuento(userDetails.getDescuento());
        factura.setTotal(userDetails.getTotal());
        final Factura updatedFactura = facturaRepository.save(factura);
        return ResponseEntity.ok(updatedFactura);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/facturas/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        Factura factura =
                facturaRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        facturaRepository.delete(factura);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}