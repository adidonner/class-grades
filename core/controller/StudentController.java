package app.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.core.entities.Student;
import app.core.exception.SchoolSystemException;
import app.core.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add-student")
	public Student addStudent(@RequestBody Student student) { // solves response error 415
		try {
			return this.studentService.addStudent(student);
		} catch (SchoolSystemException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/get-student-id/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		try {
			return this.studentService.getStudentById(studentId);
		} catch (SchoolSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}

	}
	
	@GetMapping("/all-students")
	public List<Student> getAllStudents() {
		return this.studentService.getAllStudents();
	}
	
	@PutMapping("/update-student")
	public Student updateStudent(@RequestBody Student student) {
		try {
			return this.studentService.updateStudent(student);
		} catch (SchoolSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	@DeleteMapping("/delete-student-id/{studentId}")
	public void deleteCompanyById(@PathVariable int studentId) {
		try {
			this.studentService.deleteStudentById(studentId);
		} catch (SchoolSystemException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
