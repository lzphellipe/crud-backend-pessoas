package com.luiz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.app.domain.Dependent;
import com.luiz.app.domain.People;
import com.luiz.app.domain.dto.DependentNewDto;
import com.luiz.app.repository.DependentRepository;
import com.luiz.app.repository.PeopleRepository;

@Service
public class DependentService {

	@Autowired
	private DependentRepository dependentRepository;  
	
	@Autowired
	private PeopleRepository peopleRepository;  
	
	public List<Dependent> getAllDependents() {
		return dependentRepository.findAll();
	}

	public Dependent getDependent(Integer idDependent) {
//		People people = new People();
//		Dependent dependent = 
				return dependentRepository.findById(idDependent).orElse(null);
		
//		if (dependent.getId() > 0) {
//			peopleRepository
//		}
	}

	public DependentNewDto newDependent(DependentNewDto dependentObj) throws Exception {
		People people = new People();
		
		if(dependentObj.getPeopleId() > 0) {
			people = peopleRepository.findById(dependentObj.getPeopleId()).orElse(null);
		
			Dependent dependent = new Dependent(dependentObj, people);
			
			dependent = dependentRepository.save(dependent);
			
			return new DependentNewDto(dependent);
		}
		
		throw new Exception("Não foi informado o ID de Pessoa");
	}
	
	public DependentNewDto updateDependent(DependentNewDto dependentObj) throws Exception {
		return newDependent(dependentObj);
	}

	public void deleteDependent(Integer idDependent) {
		dependentRepository.deleteById(idDependent);
	}

	public void deleteDependentByPeople(Integer idPeople) {
		dependentRepository.deleteDependentByPeopleId(idPeople);
	}
	
	
}
