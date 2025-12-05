package itch.comida.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import itch.comida.dto.clienteDTO;
import itch.comida.service.clienteService;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    private final clienteService clienteService; 

    @PostMapping
    public ResponseEntity<clienteDTO> createCliente(@Valid @RequestBody clienteDTO clienteDto) {
        clienteDTO saveCliente = clienteService.createCliente(clienteDto);
        return new ResponseEntity<>(saveCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<clienteDTO> getClienteById(@PathVariable("id") Integer id) {
        clienteDTO clienteDto = clienteService.getClienteById(id);
        return ResponseEntity.ok(clienteDto);
    }

    @GetMapping
    public ResponseEntity<List<clienteDTO>> getAllCliente() {
        List<clienteDTO> clientes = clienteService.getAllCliente();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<clienteDTO> updateCliente(
            @PathVariable("id") Integer id,
            @Valid @RequestBody clienteDTO clienteDto) {
        clienteDTO updatedCliente = clienteService.updateCliente(id, clienteDto);
        return ResponseEntity.ok(updatedCliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Integer id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("¡API funcionando correctamente!");
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existeCliente(@PathVariable("id") Integer id) {
        boolean existe = clienteService.existsById(id);
        return ResponseEntity.ok(existe);
    }
}