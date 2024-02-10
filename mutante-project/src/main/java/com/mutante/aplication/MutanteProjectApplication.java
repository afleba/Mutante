package com.mutante.aplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutanteProjectApplication {

	public static void main(String[] args) {
		String[] dna = { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		System.out.println("Resultado: ");
		System.out.println(Mutante.isMutant(dna)); // Devuelve true
	}
}
