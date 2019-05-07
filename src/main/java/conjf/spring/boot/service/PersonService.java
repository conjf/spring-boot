package conjf.spring.boot.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import conjf.spring.boot.model.Person;
import conjf.spring.boot.repository.PersonRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public class PersonService {
	
	@Autowired
	private PersonRepository personRepository; 
	
	@ApiOperation(value = "Add a person")
	@PostMapping("/addPerson")
	public Person addPerson(@ApiParam(value = "Create a Person", required = true) @Valid @RequestBody Person person) {
		return personRepository.save(person); 	
	}

}
