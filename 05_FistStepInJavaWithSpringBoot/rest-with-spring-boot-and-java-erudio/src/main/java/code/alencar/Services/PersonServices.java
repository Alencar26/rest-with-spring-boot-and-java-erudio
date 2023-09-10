package code.alencar.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import code.alencar.model.Person;

//com anotation @service eu nao preciso instanciar  a classe mualmente o Spring Faz isso por mim. 
@Service //SpringBoot entende que essa classe vai ser injetada em outras classes em tempo de execução.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public List<Person> findAll() {
        logger.info("Finding all peaple");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        logger.info("Create mock person. id = " + i);
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Address " + i);
        person.setGender("Male");
        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("André");
        person.setLastName("Alencar");
        person.setAddress("Curitiba - Paraná - Brasil");
        person.setGender("Male");
        return person;
    }
}
