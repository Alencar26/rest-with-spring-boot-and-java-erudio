package code.alencar.Services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.alencar.Controllers.PersonController;
import code.alencar.data.vo.v1.PersonVO;
import code.alencar.exceptions.ResourceNotFoundException;
import code.alencar.mapper.DozerMapper;
import code.alencar.model.Person;
import code.alencar.repositories.PersonRepository;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;;

//com anotation @service eu nao preciso instanciar  a classe mualmente o Spring Faz isso por mim. 
@Service //SpringBoot entende que essa classe vai ser injetada em outras classes em tempo de execução.
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO personVO) throws Exception {
        logger.info("Create One Person.");
        Person person = DozerMapper.parseObject(personVO, Person.class);
        PersonVO vo = DozerMapper.parseObject(repository.save(person), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public PersonVO update(PersonVO person) throws Exception {
        logger.info("Update Person.");
        Person entity = repository.findById(person.getKey()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
        
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        
        PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }

    public void delete(Long id) {
        logger.info("Delete Person.");
        Person entity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
        repository.delete(entity);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all peaple");
        //no retorno já estamos fazendo a converção da classe Person para PersonVO
        List<PersonVO> persons = DozerMapper.parseListObject(repository.findAll(), PersonVO.class);
        persons
            .stream()
            .forEach(
                p -> {
                    try {
                        p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            );
        return persons;
    }

    public PersonVO findById(Long id) throws Exception {
        logger.info("Finding one person!");
        Person personEntity = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID."));
        PersonVO vo = DozerMapper.parseObject(personEntity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;
    }
}
