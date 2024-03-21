package com.example.GYM.DTOS.Requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ProfesorRequest {
    private PersonaRequest persona;
    private List<ClaseRequest> clase;
}