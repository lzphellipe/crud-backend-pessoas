package com.luiz.app.domain.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

public class PeopleNewDto {

	@NotEmpty(message = "Campo nome é obrigatório")
	private String name;
	
	@NotEmpty(message = "Campo email é obrigatório")
	@Email(message = "Campo não está no formato de e-mail")
	private String email;
	
	@Past(message="Data de nascimento não pode ser uma data futura")
	private LocalDate dateBirth;

	
	public PeopleNewDto() {
		super();
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}


	@Override
	public String toString() {
		return "PeopleNewDto [name=" + name + ", email=" + email + ", dateBirth=" + dateBirth + "]";
	}
	
	
	
	
}
