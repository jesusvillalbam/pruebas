/**
 * 
 */
package com.springWithJsp.main.servicio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.springWithJsp.main.domain.Persona;
import com.springWithJsp.main.repository.PersonaRepository;
import com.springWithJsp.main.service.impl.PersonaServicioImpl;

/**
 * @author jevillalba
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPersonaServicio {
	
	@Mock
	PersonaRepository personaRepository;
	
	@InjectMocks
	PersonaServicioImpl personaServicio;
	
	@Test
	public void testCreatePerson() {
		Persona persona = new Persona("Jesus D", "Villalba M");
		
	}

}
