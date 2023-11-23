package code.alencar.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

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
    void testFindByAll() {
        //TODO: implement
        fail("Not implemented");
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
