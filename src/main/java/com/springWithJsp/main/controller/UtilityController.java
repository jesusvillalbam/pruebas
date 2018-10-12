package com.springWithJsp.main.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springWithJsp.main.domain.Persona2;
import com.springWithJsp.main.domain.Usuario;
import com.springWithJsp.main.repository.Persona2Repository;
import com.springWithJsp.main.repository.UsuarioRepository;

@RestController
public class UtilityController {

	@Autowired
	Persona2Repository persona2Repository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
	public String getUploadedFile(@RequestParam("file") MultipartFile file, @RequestParam("fuenteId") String fuenteId,
			@RequestParam("procesoId") String procesoId) throws IOException {
		BufferedReader br;
		InputStream is = file.getInputStream();
		br = new BufferedReader(new InputStreamReader(is));

		CSVParser parser = CSVParser.parse(br,
				CSVFormat.EXCEL.withDelimiter(',').withFirstRecordAsHeader().withIgnoreHeaderCase());

		List<Usuario> usuarios = new ArrayList<Usuario>();
		List<Persona2> personas = new ArrayList<Persona2>();

		for (CSVRecord csvRecord : parser) {
			String identificacion = csvRecord.get(0);
			String nombre = csvRecord.get(1);
			String apellido = csvRecord.get(2);
			String email = csvRecord.get(3);
			String comodin = csvRecord.get(4);

			String usuario = identificacion;
			String contrasena = "algo por ahora";
			String proceso = fuenteId;
			String fuente = procesoId;

			personas.add(new Persona2(comodin, proceso, fuente, "A", "N",
					new Usuario(usuario, contrasena, identificacion, nombre, apellido, email)));
		}

		System.out.println("Personas: " + personas.toString());

		for (Persona2 persona : personas) {

			Usuario usuarioBd = usuarioRepository.findByIdentificacion(persona.getUsuarioId().getIdentificacion());

			if (usuarioBd == null) {
				Usuario idUsuario = usuarioRepository.saveAndFlush(persona.getUsuarioId());
				persona.setUsuarioId(idUsuario);
				System.out.println("Persona a grabar" + persona.toString());
				persona2Repository.save(persona);
			} else {
				System.out.println("Paso por aquí");
				persona2Repository.inactivarPersona(persona.getFuente(), persona.getProceso(), usuarioBd.getId());
				persona.setUsuarioId(usuarioBd);
				persona2Repository.save(persona);
			}
		}
		return null;

	}

	@RequestMapping(path = "/donwloadFile", method = RequestMethod.GET)
	public ResponseEntity<Resource> donwloadFile(@RequestParam("archivo") String archivo) throws IOException {
		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + archivo + ".csv");

		File file = new ClassPathResource(archivo + ".csv").getFile();

		Path path = Paths.get(file.getAbsolutePath());

		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);

	}

	@RequestMapping(path = "/muestraConCenso", method = RequestMethod.POST)
	public String muestraConCenso(@RequestParam("proceso") String proceso, @RequestParam("fuente") String fuente) {
		
		persona2Repository.personaEsMuestraConCenso(fuente, proceso);
		return null;
	}

}
