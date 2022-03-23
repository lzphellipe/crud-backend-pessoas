package com.luiz.app.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.app.domain.People;
import com.luiz.app.domain.dto.PeopleNewDto;
import com.luiz.app.service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping
	public ResponseEntity<List<People>> listPeople() {
		
		List<People> list = peopleService.listPeople();
		System.out.println(list.toString());
		return ResponseEntity.ok().body(list);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<People> getPeople(@PathVariable("id") Integer idPeople) {
		
		People people = peopleService.getPeople(idPeople);
		System.out.println(people.toString());
		return ResponseEntity.ok().body(people);
	}
	
	@PostMapping
	public ResponseEntity<People> postPeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		People obj = new People();
		
		obj = peopleService.newPeople(peopleObj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<People> putPeople(@Valid @RequestBody People peopleObj) throws Exception {
		System.out.println("putPeople");
		People obj = new People();
		System.out.println("11111");
		obj = peopleService.updatePeople(peopleObj);
		System.out.println("44444");
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePeople(@PathVariable("id") Integer idPeople) {
		peopleService.deletePeople(idPeople);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@PostMapping
	public ResponseEntity<People> newPeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		People obj = new People();
		
		obj = peopleService.newPeople(peopleObj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<Void> updatePeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		People obj = new People();
		
		obj = peopleService.updatePeople(peopleObj);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletePeople(@Valid @RequestBody PeopleNewDto peopleObj) throws Exception {
		
		peopleService.deletePeople(peopleObj);
		
		return ResponseEntity.noContent().build();
	}
	*/
}
