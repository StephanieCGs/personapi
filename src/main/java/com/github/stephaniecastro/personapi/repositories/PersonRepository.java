package com.github.stephaniecastro.personapi.repositories;

import com.github.stephaniecastro.personapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}