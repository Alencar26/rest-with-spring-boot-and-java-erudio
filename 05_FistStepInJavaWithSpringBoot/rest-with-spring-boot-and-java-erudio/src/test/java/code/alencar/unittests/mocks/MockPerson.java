package code.alencar.unittests.mocks;

import java.util.ArrayList;
import java.util.List;

import code.alencar.data.vo.v1.PersonVO;
import code.alencar.model.Person;

public class MockPerson {
    
    public Person mockEntity() {
        return mockEntity(0);
    }

    public PersonVO mockVO() {
        return mockVO(0);
    }

    public List<Person> mockEntityList() {
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 14; i++) {
            people.add(mockEntity(i));
        }
        return people;
    }

    public List<PersonVO> mockVOList() {
        List<PersonVO> people = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            people.add(mockVO(i));
        }
        return people;
    }

    public Person mockEntity(Integer num) {
        Person person = new Person();
        person.setId(num.longValue());
        person.setFirstName("First Name" + num);
        person.setLastName("Last Name" + num);
        person.setAddress("Address" + num);
        person.setGender(((num % 2) == 0) ? "Male" : "Female");
        return person;
    }

    public PersonVO mockVO(Integer num) {
        PersonVO person = new PersonVO();
        person.setKey(num.longValue());
        person.setFirstName("First Name" + num);
        person.setLastName("Last Name" + num);
        person.setAddress("Address" + num);
        person.setGender(((num % 2) == 0) ? "Male" : "Female");
        return person;
    }
}
