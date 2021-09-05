package com.elotech.peoplecontacts.repository;

import com.elotech.peoplecontacts.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
