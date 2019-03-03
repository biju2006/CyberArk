package com.example.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jpa.repo.beans.People;

public interface PeopleRepository extends JpaRepository<People,Long>{
	
}
