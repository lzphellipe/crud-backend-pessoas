package com.luiz.app.rest;

import java.util.List;
import java.util.Map;

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

import com.luiz.app.domain.Dependent;
import com.luiz.app.domain.dto.DependentNewDto;
import com.luiz.app.domain.enums.DependentType;
import com.luiz.app.service.DependentService;

@RestController
@RequestMapping("/api/dependent")
public class DependentController {

	@Autowired
	private DependentService dependentService;
	
	@GetMapping("/dependent-type")
	public ResponseEntity<Map<Integer, String>> getAllDependentType() {
		return ResponseEntity.ok().body(DependentType.listEnumToMap());
	}
	
	@GetMapping
	public ResponseEntity<List<Dependent>> getAllDependents() {
		
		List<Dependent> dependents = dependentService.getAllDependents();
		
		return ResponseEntity.ok().body(dependents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dependent> getDependent(@PathVariable("id") Integer idDependent) {
		
		Dependent dependent = dependentService.getDependent(idDependent);
		
//		DependentReturnDto
		
		return ResponseEntity.ok().body(dependent);
	}
	
	@PostMapping
	public ResponseEntity<DependentNewDto> postDependent(@Valid @RequestBody DependentNewDto dependentObj) 
			throws Exception {
		
		DependentNewDto obj = new DependentNewDto();
		
		obj = dependentService.newDependent(dependentObj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping
	public ResponseEntity<DependentNewDto> putDependent(@Valid @RequestBody DependentNewDto dependentObj) 
			throws Exception {
		
		DependentNewDto obj = dependentService.updateDependent(dependentObj);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDependent(@PathVariable("id") Integer idDependent) {
		
		dependentService.deleteDependent(idDependent);
		
		return ResponseEntity.noContent().build();
	}
	
}
