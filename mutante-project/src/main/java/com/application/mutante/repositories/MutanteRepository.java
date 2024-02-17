package com.application.mutante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.mutante.entities.MutanteEntity;


@SuppressWarnings("unused")
@Repository
public interface MutanteRepository extends JpaRepository<MutanteEntity, Long> {
    
	@Query(value = "select count (*) from mutante")
	long countByMutant(boolean mutant);
}
