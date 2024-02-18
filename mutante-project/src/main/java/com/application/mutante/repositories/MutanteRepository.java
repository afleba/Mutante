package com.application.mutante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.mutante.entities.MutanteEntity;


@SuppressWarnings("unused")
@Repository
public interface MutanteRepository extends JpaRepository<MutanteEntity, Long> {
    
	@Query("SELECT COUNT(m) FROM MutanteEntity m WHERE m.estado_mutante = :mutant")
    long countByMutant(@Param("mutant") boolean mutant);
}
