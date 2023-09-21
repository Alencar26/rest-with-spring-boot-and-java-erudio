package code.alencar.Controllers;

import code.alencar.Services.PersonServices;
import code.alencar.data.vo.v1.PersonVO;
import code.alencar.util.MediaType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value = "/api/person/v1")
public class PersonController {

	@Autowired //usado para o SpringBoot injetar a classe sem usar o "new"
	private PersonServices services;

	@PostMapping(
		consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, //consome JSON, XML e YAML
		produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) //consome JSON, XML e YAML
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return services.create(person);
	}
	
	@PutMapping(
		consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, //consome JSON, XML e YAML
		produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}) //consome JSON, XML e YAML
	public ResponseEntity<PersonVO> update(@RequestBody PersonVO person) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(services.update(person));
	}
	
	@GetMapping(
		value ="/{id}",
		produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<PersonVO> findById(	@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(services.findById(id));
	}

	@GetMapping(
		produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public List<PersonVO> findAll() {
		return services.findAll();
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT) //204
	@DeleteMapping(
		value ="/{id}")
	public void delete(	@PathVariable(value = "id") Long id) throws Exception {
		services.delete(id);
	}
}
