package com.luiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.app.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
