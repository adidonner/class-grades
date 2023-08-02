package app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Grade;

public interface GradesRepository extends JpaRepository<Grade, Integer> {

	

}
