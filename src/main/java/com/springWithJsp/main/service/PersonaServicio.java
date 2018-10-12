package com.springWithJsp.main.service;

import java.util.List;

import com.springWithJsp.main.domain.Persona;
import com.springWithJsp.main.util.exception.GeneralException;

public interface PersonaServicio {
	
	public Persona findPersona(Integer id) throws GeneralException;
	
	public List<Persona> findPersonas() throws GeneralException;
	
	public void savePersona(Persona persona) throws GeneralException;
	
	public void deletePersona(Integer id);
}
