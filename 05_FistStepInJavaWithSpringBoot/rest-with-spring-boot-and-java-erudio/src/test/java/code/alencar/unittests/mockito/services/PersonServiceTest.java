package code.alencar.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import code.alencar.Services.PersonServices;
import code.alencar.data.vo.v1.PersonVO;
import code.alencar.exceptions.RequiredObjectIsNullException;
import code.alencar.model.Person;
import code.alencar.repositories.PersonRepository;
import code.alencar.unittests.mocks.MockPerson;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    
    MockPerson input;

    @InjectMocks //injetando os mocks da classe PersonService
    private PersonServices service;

    @Mock
    PersonRepository repository;

    @BeforeEach //setando os mocks
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Person> list = input.mockEntityList();
        when(repository.findAll()).thenReturn(list);

        List<PersonVO> people = service.findAll();
        
        assertNotNull(people);
        assertEquals(14, people.size());

        PersonVO personZero = people.get(0);
        assertNotNull(personZero);
        assertNotNull(personZero.getKey());
        assertNotNull(personZero.getLinks());
        assertTrue(personZero.toString().contains("links: [</api/person/v1/0>;rel=\"self\"]"));
        assertEquals("Address0", personZero.getAddress());
        assertEquals("Male", personZero.getGender());
        assertEquals("First Name0", personZero.getFirstName());
        assertEquals("Last Name0", personZero.getLastName());

        PersonVO personQuatro = people.get(4);
        assertNotNull(personQuatro);
        assertNotNull(personQuatro.getKey());
        assertNotNull(personQuatro.getLinks());
        assertTrue(personQuatro.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));
        assertEquals("Address4", personQuatro.getAddress());
        assertEquals("Male", personQuatro.getGender());
        assertEquals("First Name4", personQuatro.getFirstName());
        assertEquals("Last Name4", personQuatro.getLastName());

        PersonVO personSete = people.get(7);
        assertNotNull(personSete);
        assertNotNull(personSete.getKey());
        assertNotNull(personSete.getLinks());
        assertTrue(personSete.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));
        assertEquals("Address7", personSete.getAddress());
        assertEquals("Female", personSete.getGender());
        assertEquals("First Name7", personSete.getFirstName());
        assertEquals("Last Name7", personSete.getLastName());

    }

    @Test
    void testFindById() throws Exception {
        Person entity = input.mockEntity();
        entity.setId(1L);
        
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        PersonVO result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address0", result.getAddress());
        assertEquals("Male", result.getGender());
        assertEquals("First Name0", result.getFirstName());
        assertEquals("Last Name0", result.getLastName());
    }

    @Test
    void testCreate() throws Exception {
        //entity antes de persistir
        Person entity = input.mockEntity();
        
        //entity depois de persistir
        Person persisted = entity;
        persisted.setId(1L);
        
        PersonVO vo = input.mockVO();
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);
        PersonVO result = service.create(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address0", result.getAddress());
        assertEquals("Male", result.getGender());
        assertEquals("First Name0", result.getFirstName());
        assertEquals("Last Name0", result.getLastName());
    }

    @Test
    void testCreateWithNullPerson() throws Exception {
        Exception expected = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.create(null);
        });

        String expectMessage = "It is not allowed to persist null objects.";
        String actualMessage = expected.getMessage();

        assertTrue(actualMessage.contains(expectMessage));
    }

        @Test
    void testUpdateWithNullPerson() throws Exception {
        Exception expected = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.update(null);
        });

        String expectMessage = "It is not allowed to persist null objects.";
        String actualMessage = expected.getMessage();

        assertTrue(actualMessage.contains(expectMessage));
    }

    @Test
    void testUpdate() throws Exception {
        //entity antes de persistir
        Person entity = input.mockEntity();
        entity.setId(1L);

        //entity depois de persistir
        Person persisted = entity;
        persisted.setId(1L);
        
        PersonVO vo = input.mockVO();
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);
        PersonVO result = service.update(vo);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
        assertEquals("Address0", result.getAddress());
        assertEquals("Male", result.getGender());
        assertEquals("First Name0", result.getFirstName());
        assertEquals("Last Name0", result.getLastName());
    }

    @Test 
    void testDelete() {
        Person entity = input.mockEntity();
        entity.setId(1L);
        
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        service.delete(1L);
    }
}
