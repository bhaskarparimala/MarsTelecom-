package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.model.Person;
import com.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Save the person
	 * @param person
	 * @return
	 */
	public Person createPerson(Person person) {
		//System.out.println("$$$$ Person.FirstName" +person.getFirstName() + " "+  person.getLastName() +" "+person.getEmail());
		return personRepository.save(person);
	}

	/**
	 * Retrieves all the persons
	 * @return
	 */
	public Iterable<Person> getAllPersons(){
		return personRepository.findAll();
	}

	/**
	 * Retrieve single person
	 * @param personId
	 * @return
	 */
	public Person getPerson(Integer personId) {
		return personRepository.findById(personId) //If person exists then directly returned
				.orElse(new Person());//If person does not exists it will return dummyobj
	}

	/**
	 * Update the person details.
	 * @param personId
	 * @param email
	 * @return
	 */
	public Person updatePerson(Integer personId,Person personDetails) {

		//Get person record by person Id
		Person personObj=getPerson(personId);
		//now set the new email
		personObj.setFirstName(personDetails.getFirstName());
		personObj.setLastName(personDetails.getLastName());
		personObj.setEmail(personDetails.getEmail());
		personObj.setAddress(personDetails.getAddress());
		return personRepository.save(personObj);

	}
	
	/**
	 * Deletes the person
	 * @param personId
	 */

	public void deletePerson(Integer personId) {
		personRepository.deleteById(personId);
	}

}
