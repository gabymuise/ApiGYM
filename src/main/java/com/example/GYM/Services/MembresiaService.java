package com.example.GYM.Services;

import com.example.GYM.DTOS.Requests.MembresiaRequest;
import com.example.GYM.DTOS.Response.MembresiaResponse;
import com.example.GYM.Mappers.MembresiaMapper;
import com.example.GYM.Models.Membresia;
import com.example.GYM.Repositories.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Autowired
    private MembresiaMapper membresiaMapper;

    public MembresiaResponse crearMembresia(MembresiaRequest request) {
        Membresia membresia = membresiaMapper.toMembresia(request);
        membresia = membresiaRepository.save(membresia);
        return membresiaMapper.toMembresiaResponse(membresia);
    }

    public List<MembresiaResponse> listarMembresias() {
        List<Membresia> membresias = membresiaRepository.findAll();
        return membresias.stream()
                .map(membresiaMapper::toMembresiaResponse)
                .collect(Collectors.toList());
    }

    public void eliminarMembresia(Long id) {
        membresiaRepository.deleteById(id);
    }
}
