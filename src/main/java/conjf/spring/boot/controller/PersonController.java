package conjf.spring.boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import conjf.spring.boot.exception.ResourceNotFoundException;
import conjf.spring.boot.model.Person;
import conjf.spring.boot.repository.PersonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Person Management System", tags="Person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository; 
	
	@ApiOperation(value = "Add a person")
	@PostMapping("/addPerson")
	public Person addPerson(@ApiParam(value = "Create a Person", required = true) @Valid @RequestBody Person person) {
		return personRepository.save(person); 	
	}
	
	@ApiOperation(value = "Get a Person by Id", produces = "application/json", response = ResponseEntity.class, tags = {"Person"})
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success", response = ResponseEntity.class) })
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(
		@ApiParam(value = "ID of the person to be retrieved", required = true) @PathVariable(value = "id") Long personId)
		throws ResourceNotFoundException {
		Person person = personRepository.findById(personId).orElseThrow(() -> new ResourceNotFoundException("Person not found - id : " + personId));
		return ResponseEntity.ok().body(person); 
	}

}
