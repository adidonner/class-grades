package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.entities.Grade;
import app.core.entities.Student;

@Configuration
@ComponentScan
public class config {

	@Bean
	@Scope("prototype")
	public Grade grade() {
		Grade grade = new Grade();
		return grade;
	}
	@Bean
	@Scope("prototype")
	public Student student() {
		Student student = new Student();
		return student;
	}
}
