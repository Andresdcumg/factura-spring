package com.wtorresd1.Facturass.controller;

import com.wtorresd1.Facturass.exception.ResourceNotFoundException;
import com.wtorresd1.Facturass.model.Producto;
import com.wtorresd1.Facturass.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/productos")
    public List<Producto> getAllUsers() {
        return productoRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Producto producto =
                productoRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(producto);
    }

    /**
     * Create user user.
     *
     * @param producto the user
     * @return the user
     */
    @PostMapping("/productos")
    public Producto createUser(@Valid @RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Update user response entity.
     *
     * @param userId      the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Producto userDetails)
            throws ResourceNotFoundException {

        Producto producto =
                productoRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        producto.setNombre(userDetails.getNombre());
        producto.setVence(userDetails.getVence());
        producto.setLote(userDetails.getLote());
        producto.setCantidad(userDetails.getCantidad());
        final Producto updatedProducto = productoRepository.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/productos/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        Producto producto =
                productoRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        productoRepository.delete(producto);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}