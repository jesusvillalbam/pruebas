package com.springWithJsp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springWithJsp.main.domain.Persona2;

@Repository
public interface Persona2Repository extends JpaRepository<Persona2, Integer> {

	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query(value = "UPDATE Persona2 SET estado = 'I' WHERE fuente = ?1 "
			+ "AND proceso = ?2 AND usuario_id = ?3 AND terminado='N' AND estado = 'A' ", nativeQuery = true)
	void inactivarPersona(String fuente, String proceso, Integer usuarioId);
	
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query(value = "UPDATE Persona2 SET es_muestra = 'S' WHERE proceso = ?1 "
			+ "AND fuente = ?2 AND terminado='N' AND estado = 'A' ", nativeQuery = true)
	void personaEsMuestraConCenso(String proceso, String fuente);
	
	@Modifying(flushAutomatically = true, clearAutomatically = true)
	@Transactional(readOnly = false)
	@Query(value = "UPDATE Persona2 SET es_muestra = 'S' WHERE proceso = ?1 "
			+ "AND fuente = ?2 AND AND persona = ?3 AND terminado='N' AND estado = 'A' ", nativeQuery = true)
	void personaEsMuestraAleatoria(String proceso, String fuente, Integer personaId);
}
