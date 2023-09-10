package code.alencar.Services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import code.alencar.model.Person;

//com anotation @service eu nao preciso instanciar  a classe mualmente o Spring Faz isso por mim. 
@Service //SpringBoot entende que essa classe vai ser injetada em outras classes em tempo de execução.
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

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
