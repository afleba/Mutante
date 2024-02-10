package com.application.mutante.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.mutante.clases.Mutante;
import com.application.mutante.dto.MutanteDTO;

@RestController
public class MutanteController {

    @PostMapping("/mutant")
    public ResponseEntity<String> detectMutant(@RequestBody MutanteDTO mutantRequest) {
        String[] dna = mutantRequest.getDna();
        boolean isMutant = Mutante.isMutant(dna);
        
        if (isMutant) {
            return ResponseEntity.ok().build(); // Devuelve HTTP 200 OK si es mutante
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve HTTP 403 Forbidden si no es mutante
        }
    }
}