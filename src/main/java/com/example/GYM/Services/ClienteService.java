package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.ClienteRequest;
import com.example.GYM.Mappers.ClienteMapper;
import com.example.GYM.Models.Cliente;
import com.example.GYM.Repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private PersonaService personaService;

    public String registrarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        //cliente.setPersona(clienteMapper.clienteRequestToPersona(clienteRequest));
        clienteRepository.save(cliente);
        //return "Cliente guardado: " + cliente.getPersona().getNombre() + " " + cliente.getPersona().getApellido();
        return null;
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}