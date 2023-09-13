package code.alencar.Controllers;

import code.alencar.Services.PersonServices;
import code.alencar.model.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired //usado para o SpringBoot injetar a classe sem usar o "new"
	private PersonServices services;

	@RequestMapping(
		method = RequestMethod.POST, 
		consumes = MediaType.APPLICATION_JSON_VALUE, //consome JSON
		produces = MediaType.APPLICATION_JSON_VALUE) //produz JSON
	public Person create(@RequestBody Person person) throws Exception {
		return services.create(person);
	}
	
	@RequestMapping(
		method = RequestMethod.PUT, 
		consumes = MediaType.APPLICATION_JSON_VALUE, //consome JSON
		produces = MediaType.APPLICATION_JSON_VALUE) //produz JSON
	public Person update(@RequestBody Person person) throws Exception {
		return services.update(person);
	}
	
	@RequestMapping(
		value ="/{id}", 
		method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(	@PathVariable(value = "id") Long id) throws Exception {
		return services.findById(id);
	}

	@RequestMapping(
		method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return services.findAll();
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT) //204
	@RequestMapping(
		value ="/{id}", 
		method = RequestMethod.DELETE)
	public void delete(	@PathVariable(value = "id") Long id) throws Exception {
		services.delete(id);
	}
}
