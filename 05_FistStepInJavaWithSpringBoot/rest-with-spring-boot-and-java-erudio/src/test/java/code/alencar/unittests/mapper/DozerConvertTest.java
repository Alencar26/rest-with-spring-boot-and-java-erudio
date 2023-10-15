package code.alencar.unittests.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import code.alencar.data.vo.v1.PersonVO;
import code.alencar.mapper.DozerMapper;
import code.alencar.model.Person;
import code.alencar.unittests.mocks.MockPerson;

public class DozerConvertTest {
    
    MockPerson inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonVO person = DozerMapper.parseObject(inputObject.mockEntity(), PersonVO.class);
        assertEquals(Long.valueOf(0), person.getKey());
        assertEquals("First Name0", person.getFirstName());
        assertEquals("Last Name0", person.getLastName());
        assertEquals("Address0", person.getAddress());
        assertEquals("Male", person.getGender());
    }


    @Test
    public void parseEntityListToVOListTest() {
        List<PersonVO> personList = DozerMapper.parseListObject(inputObject.mockEntityList(), PersonVO.class);
        PersonVO personZero = personList.get(0), 
                 personSete = personList.get(7),
                 personDozer = personList.get(12);

        assertEquals(Long.valueOf(0), personZero.getKey());
        assertEquals("First Name0", personZero.getFirstName());
        assertEquals("Last Name0", personZero.getLastName());
        assertEquals("Address0", personZero.getAddress());
        assertEquals("Male", personZero.getGender());

        assertEquals(Long.valueOf(7), personSete.getKey());
        assertEquals("First Name7", personSete.getFirstName());
        assertEquals("Last Name7", personSete.getLastName());
        assertEquals("Address7", personSete.getAddress());
        assertEquals("Female", personSete.getGender());

        assertEquals(Long.valueOf(12), personDozer.getKey());
        assertEquals("First Name12", personDozer.getFirstName());
        assertEquals("Last Name12", personDozer.getLastName());
        assertEquals("Address12", personDozer.getAddress());
        assertEquals("Male", personDozer.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person person = DozerMapper.parseObject(inputObject.mockVO(), Person.class);

        assertEquals(Long.valueOf(0), person.getId());
        assertEquals("First Name0", person.getFirstName());
        assertEquals("Last Name0", person.getLastName());
        assertEquals("Address0", person.getAddress());
        assertEquals("Male", person.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> personList = DozerMapper.parseListObject(inputObject.mockVOList(), Person.class);
        Person personZero = personList.get(0), 
                 personSete = personList.get(7),
                 personDozer = personList.get(12);

        assertEquals(Long.valueOf(0), personZero.getId());
        assertEquals("First Name0", personZero.getFirstName());
        assertEquals("Last Name0", personZero.getLastName());
        assertEquals("Address0", personZero.getAddress());
        assertEquals("Male", personZero.getGender());

        assertEquals(Long.valueOf(7), personSete.getId());
        assertEquals("First Name7", personSete.getFirstName());
        assertEquals("Last Name7", personSete.getLastName());
        assertEquals("Address7", personSete.getAddress());
        assertEquals("Female", personSete.getGender());

        assertEquals(Long.valueOf(12), personDozer.getId());
        assertEquals("First Name12", personDozer.getFirstName());
        assertEquals("Last Name12", personDozer.getLastName());
        assertEquals("Address12", personDozer.getAddress());
        assertEquals("Male", personDozer.getGender());
    }
}
