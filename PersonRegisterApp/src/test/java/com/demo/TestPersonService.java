package com.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.demo.model.Address;
import com.demo.model.Person;
import com.demo.repository.PersonRepository;
import com.demo.service.PersonService;

//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class TestPersonService {

	@Mock
	private PersonRepository personRepo;
	
	@InjectMocks
	private PersonService personService;
	
	
	
	@Test
	public void testGetPersonById() {
		Integer id=1;
		 Address address = new Address(1, "c311", "madhapur", "hyderabad");
		 Person person = new Person(1,"bhaskar","parimala","bp@gmail.com",address);
		
		 when(personRepo.findById(id)).thenReturn(Optional.of(person));
		
		Person personObj = personService.getPerson(id);
		
		System.out.println(personObj.getFirstName());
		assertEquals("bhaskar",personObj.getFirstName());
		
	}
	
	@Test
	public void testSavePerson() {
		 Address address = new Address(1, "c311", "madhapur", "hyderabad");
		 Person person = new Person(1,"bhaskar","parimala","bp@gmail.com",address);
		personService.createPerson(person);
		verify(personRepo, times(1)).save(person);
	}
	
	@Test
    public void testGetAllPersons()
    {
        List<Person> personList = new ArrayList<Person>();
        Person person1 = new Person(1, "bp", "parimal", "bp@gmail.com",new Address(1, "b402", "madhapur", "hyderabad"));
        Person person2 = new Person(2, "rp", "billa", "rp@gmail.com",new Address(2, "k301", "kphb", "hyderabad"));
        personList.add(person1);
        personList.add(person2);
        when(personRepo.findAll()).thenReturn(personList);
        List<Person> personList2 = (List<Person>) personService.getAllPersons();
        assertEquals(2, personList2.size());
        verify(personRepo, times(1)).findAll();
    }
}
