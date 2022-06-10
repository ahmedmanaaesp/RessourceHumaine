package com.esprit.microservice.employeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/employes")
public class EmployeRestAPI {
	
	@Autowired
	private EmployeService employeService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employe>> getAllEmployees () {
        List<Employe> employees = employeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Employe> createEmploye(@RequestBody Employe employe) {
		return new ResponseEntity<>(employeService.addEmploye(employe), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employe> updateEmploye(@PathVariable(value = "id") int id,
    										@RequestBody Employe employe){
		return new ResponseEntity<>(employeService.updateEmploye(id, employe), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteEmploye(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(employeService.deleteEmploye(id), HttpStatus.OK);
	}
}
