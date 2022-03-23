package com.luiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luiz.app.domain.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Integer> {

	@Modifying
    @Transactional
	@Query("DELETE FROM Dependent d WHERE d.people.id=:idPeople")
	void deleteDependentByPeopleId(@Param("idPeople") Integer idPeople);
	
}
