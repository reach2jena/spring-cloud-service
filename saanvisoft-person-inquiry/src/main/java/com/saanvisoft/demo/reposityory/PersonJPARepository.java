package com.saanvisoft.demo.reposityory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saanvisoft.demo.dto.Person;

@Repository
public interface PersonJPARepository extends JpaRepository<Person, Integer> {

}
