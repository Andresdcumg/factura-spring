package com.wtorresd1.Facturass.controller;

import com.wtorresd1.Facturass.exception.ResourceNotFoundException;
import com.wtorresd1.Facturass.model.Cliente;
import com.wtorresd1.Facturass.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/clientes")
    public List<Cliente> getAllUsers() {
        return clienteRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param userId the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        Cliente cliente =
                clienteRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(cliente);
    }

    /**
     * Create user user.
     *
     * @param cliente the user
     * @return the user
     */
    @PostMapping("/clientes")
    public Cliente createUser(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Update user response entity.
     *
     * @param userId      the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateUser(
            @PathVariable(value = "id") Long userId, @Valid @RequestBody Cliente userDetails)
            throws ResourceNotFoundException {

        Cliente cliente =
                clienteRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        cliente.setNombre(userDetails.getNombre());
        cliente.setNit(userDetails.getNit());
        cliente.setDireccion(userDetails.getDireccion());
        final Cliente updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/clientes/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
        Cliente cliente =
                clienteRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        clienteRepository.delete(cliente);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}