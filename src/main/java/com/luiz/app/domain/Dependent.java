package com.luiz.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.luiz.app.domain.dto.DependentNewDto;
import com.luiz.app.domain.object.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="dependent")
public class Dependent extends Person {
	
	@ManyToOne(targetEntity=People.class)
	@JoinColumn(referencedColumnName = "id", name="people_id")
	private People people;	
	
	@Column(nullable=false)
	private Integer dependentType;

	public Dependent() {
		super();
	}
	
	public Dependent(DependentNewDto peopleNewDto, People people) {
		this.id = peopleNewDto.getId();
		this.name = peopleNewDto.getName();
		this.dateBirth = peopleNewDto.getDateBirth();
		this.dependentType = peopleNewDto.getDependentType();
		this.people = people;
	}
	
	@JsonIgnore
	public People getPeople() {
		return people;
	}
	
	public String getPeopleName() {
		return people.getName();
	}


	public void setPeople(People people) {
		this.people = people;
	}

	public Integer getDependentType() {
		return this.dependentType;
//		return DependentType.toEnum(this.dependentType);
	}
	
	public void setDependentType(Integer dependentType) {
		this.dependentType = dependentType;
	}

}
