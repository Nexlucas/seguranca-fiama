package com.biolab.seguranca.service;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.entity.Cliente;
import com.biolab.seguranca.entity.Role;
import com.biolab.seguranca.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;

    public ClienteService(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Cliente criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(passwordEncoder.encode(dto.getSenha()));
        if(dto.getRole() == null){
            cliente.setRole(Role.ROLE_USER);
        }else {
            cliente.setRole(dto.getRole());
        }
        clienteRepository.save(cliente);
        return cliente;
    }
}
