package com.springWithJsp.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springWithJsp.main.domain.Persona;
import com.springWithJsp.main.service.PersonaServicio;
import com.springWithJsp.main.util.exception.GeneralException;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(path = "/persona")
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	PersonaServicio personaServicio;

	@RequestMapping(method = RequestMethod.GET)
	public String viewPersonList(Model model) {
		List<Persona> personas = null;
		try {
			personas = personaServicio.findPersonas();
			logger.info("Personas: " + personas.toString());
		} catch (GeneralException e) {
			e.printStackTrace();
			logger.error("Error al consultar las personas: " + e.getMessage());
		}
		model.addAttribute("personas", personas);

		return "personas";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String obtenerPersona(Model model, @PathVariable Integer id) {
		Persona persona = null;
		try {
			persona = personaServicio.findPersona(id);
			model.addAttribute("persona", persona);
		} catch (GeneralException e) {
			e.printStackTrace();
		}

		return "personas";
	}
	
	@RequestMapping(path="/agregar", method = RequestMethod.GET)
    public String setupForm(Model model)
    {
         Persona persona = new Persona();
         model.addAttribute("personaAdd", persona);
         return "personas";
    }
	
	@RequestMapping(path="/agregar", method = RequestMethod.POST)
	public String agregarPersona(@ModelAttribute("personaAdd") Persona persona) {
		try {
			personaServicio.savePersona(persona);
		} catch (GeneralException e) {
			logger.error(e.getMessage());
		}
		System.out.println(persona.toString());
		return "redirect:persona";
	}
}
