package com.springWithJsp.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springWithJsp.main.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
