package code.alencar.Controllers;

import code.alencar.Services.PersonServices;
import code.alencar.model.Person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired //usado para o SpringBoot injetar a classe sem usar o "new"
	private PersonServices services;

	@RequestMapping(
		value ="/{id}", 
		method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public Person findById(	@PathVariable(value = "id") String id) throws Exception {
		return services.findById(id);
	}

	@RequestMapping(
		method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Person> findAll() {
		return services.findAll();
	}
}
