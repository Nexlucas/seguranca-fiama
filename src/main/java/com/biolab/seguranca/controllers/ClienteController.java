package com.biolab.seguranca.controllers;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> ola(){
        return ResponseEntity.ok("Olá");
    }
    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.criarCliente(dto));
    }
}
