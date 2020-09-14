package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;
import com.demo.service.PersonService;


@RestController
@RequestMapping("/persons/")
public class PersonController {

	@Autowired
	private PersonService personService;

	//http://localhost:8080/persons/allPersons
	@GetMapping("allPersons")
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<Person>getAllPersons() {
		return personService.getAllPersons();
	}

	//http://localhost:8080/persons/person/1
	@GetMapping("person/{pid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Person getPerson(@PathVariable("pid") Integer pid) {
		return personService.getPerson(pid);
	}

	//http://localhost:8080/persons/create
	@PostMapping("create")
	@CrossOrigin(origins = "http://localhost:4200")
	public Person createPerson(@RequestBody Person personObj) {
		System.out.println("$$$$$ inside create person...$$$$$");
		return personService.createPerson(personObj);
	}

	//http://localhost:8080/persons/1/bp@gmail.com
	@PutMapping("personUpdate/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Person updatePerson(@PathVariable("id") Integer pid, @RequestBody Person personDetails) {
		return personService.updatePerson(pid, personDetails);
	}

	//Delete person
	//http://localhost:8080/persons/person/1
	@DeleteMapping(value="person/{pid}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteTicket(@PathVariable("pid") Integer pid) {
		personService.deletePerson(pid);
	}

}
