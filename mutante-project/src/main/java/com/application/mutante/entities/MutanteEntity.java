package com.application.mutante.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MUTANTE")
public class MutanteEntity implements Serializable {
	
	  	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	
	  	@Column(name = "dna_mutante")
	    private String dna_mutante;
	  	
	  	@Column (name = "estado_mutante")
	    private boolean estado_mutante;
		
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDna() {
			return dna_mutante;
		}
		public void setDna(String dna) {
			this.dna_mutante = dna;
		}
		public boolean isMutante() {
			return estado_mutante;
		}
		public void setEstadoMutante(boolean mutant) {
			this.estado_mutante = mutant;
		}
	    
	    
	    

}
