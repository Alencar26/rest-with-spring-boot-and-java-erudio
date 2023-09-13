package code.alencar.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.alencar.exceptions.ResourceNotFoundException;
import code.alencar.model.Person;
import code.alencar.repositories.PersonRepository;

//com anotation @service eu nao preciso instanciar  a classe mualmente o Spring Faz isso por mim. 
@Service //SpringBoot entende que essa classe vai ser injetada em outras classes em tempo de execução.
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        logger.info("Create One Person.");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update Person.");
        Person entity = repository.findById(person.getId()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        
        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Delete Person.");
        Person entity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }

    public List<Person> findAll() {
        logger.info("Finding all peaple");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
    }
}
