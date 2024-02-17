package com.application.mutante.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.mutante.clases.Mutante;
import com.application.mutante.dto.MutanteDTO;
import com.application.mutante.entities.MutanteEntity;
import com.application.mutante.repositories.MutanteRepository;

@RestController
public class MutanteController {
	
	@Autowired
    private MutanteRepository mutanteRepository;

    @PostMapping("/mutant")
    public ResponseEntity<String> detectMutant(@RequestBody MutanteDTO mutantRequest) {
    	 String[] dna = mutantRequest.getDna();
         boolean isMutant = Mutante.isMutant(dna);
         
         MutanteEntity mutante = new MutanteEntity();
         mutante.setDna("prueba");
         mutante.setEstadoMutante(true);
         mutanteRepository.save(mutante);
        
        if (isMutant) {
            return ResponseEntity.ok().build(); // Devuelve HTTP 200 OK si es mutante
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve HTTP 403 Forbidden si no es mutante
        }
    }
}