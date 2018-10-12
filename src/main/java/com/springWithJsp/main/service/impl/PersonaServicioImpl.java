/**
 * 
 */
package com.springWithJsp.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springWithJsp.main.domain.Persona;
import com.springWithJsp.main.repository.PersonaRepository;
import com.springWithJsp.main.service.PersonaServicio;
import com.springWithJsp.main.util.exception.GeneralException;

/**
 * @author jevillalba
 *
 */

@Service
public class PersonaServicioImpl implements PersonaServicio{
	
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public Persona findPersona(Integer id) throws GeneralException {
		Persona persona = null;
		try {
			persona= personaRepository.findById(id).get();
		} catch (Exception e) {
			throw new GeneralException("Not Found");
		}
		return persona;
	}

	@Override
	public List<Persona> findPersonas() throws GeneralException {
		List<Persona> personas = null;
		try {
			personas = personaRepository.findAll();
		} catch (Exception e) {
			throw new GeneralException("Ha ocurrido un error consultando los datos!");
		}
		
		return personas;
	}

	@Override
	@Transactional(rollbackFor=GeneralException.class)
	public void savePersona(Persona persona) throws GeneralException {
		try {
			personaRepository.save(persona);
		} catch (Exception e) {
			throw new GeneralException("Error al guardar la entidad");
		}
	}

	@Override
	public void deletePersona(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
