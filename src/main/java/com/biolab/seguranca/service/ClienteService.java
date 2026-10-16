package com.biolab.seguranca.service;

import com.biolab.seguranca.dto.ClienteDTO;
import com.biolab.seguranca.entity.Cliente;
import com.biolab.seguranca.entity.Role;
import com.biolab.seguranca.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        if(dto.getRole() == null){
            cliente.setRole(Role.ROLE_USER);
        }else {
            cliente.setRole(dto.getRole());
        }
        clienteRepository.save(cliente);
        return cliente;
    }
}
