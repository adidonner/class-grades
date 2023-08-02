package app.core;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import app.core.entities.Grade;
import app.core.entities.Student;
import app.core.entities.Topic;
import app.core.service.StudentService;

@Component
public class SchoolTesting implements CommandLineRunner {

	@Autowired
	private StudentService studentService;

	@Autowired
	private ApplicationContext ctx;

	@Override
	public void run(String... args) throws Exception {

		// setting a student
		Student student1 = ctx.getBean(Student.class);
		student1.setName("Amir");
		student1.setIsActive(true);
		Date sqlDate = Date.valueOf("2020-12-31");
		student1.setBirthday(sqlDate);

		// setting a list of grades
		Grade grade1 = ctx.getBean(Grade.class);
		grade1.setTopic(Topic.GEOGRAPHY);
		grade1.setScore(88);
		Grade grade2 = ctx.getBean(Grade.class);
		grade2.setTopic(Topic.LITERATURE);
		grade2.setScore(97);
		Grade grade3 = ctx.getBean(Grade.class);
		grade3.setTopic(Topic.MATH);
		grade3.setScore(92);
		student1.addGrade(grade1);
		student1.addGrade(grade2);
		student1.addGrade(grade3);

		studentService.addStudent(student1);// saving in data repository
		System.out.println(student1);
		System.out.println(student1.getGrades());

		Date sqlDate2 = Date.valueOf("2022-9-17");
		Student student2 = new Student(0, "Eden", sqlDate2, false, null);

		Grade grade4 = ctx.getBean(Grade.class);
		grade4.setTopic(Topic.GEOGRAPHY);
		grade4.setScore(93);
		Grade grade5 = ctx.getBean(Grade.class);
		grade5.setTopic(Topic.LITERATURE);
		grade5.setScore(90);
		Grade grade6 = ctx.getBean(Grade.class);
		grade6.setTopic(Topic.MATH);
		grade6.setScore(83);

		List<Grade> grades = Arrays.asList(grade4, grade5, grade6);
		student2.setGrades(grades);
		studentService.addStudent(student2);
		System.out.println(student2);
		System.out.println(student2.getGrades());
	}

}
