package com.application.mutante.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
         mutante.setDna(Arrays.toString(dna));
         mutante.setEstadoMutante(isMutant);
         mutanteRepository.save(mutante);
        
        if (isMutant) {
            return ResponseEntity.ok().build(); // Devuelve HTTP 200 OK si es mutante
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // Devuelve HTTP 403 Forbidden si no es mutante
        }
    }
    
	@GetMapping("/stats")
	public ResponseEntity<Map<String, Object>> getStats() {
		Long countMutantDna = mutanteRepository.countByMutant(true);
		Long countHumanDna = mutanteRepository.countByMutant(false);
		Double ratio = 0.0;
		
		if( countMutantDna!=null && countHumanDna!=null &&countHumanDna!=0L) {
			ratio=(double) (countMutantDna / countHumanDna) ;
		}

		Map<String, Object> stats = new HashMap<>();
		stats.put("count_mutant_dna", countMutantDna);
		stats.put("count_human_dna", countHumanDna);
		stats.put("ratio", ratio);

		return ResponseEntity.ok(stats);
	}

}