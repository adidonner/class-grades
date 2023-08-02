package app.core.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Grade;
import app.core.entities.Student;
import app.core.exception.SchoolSystemException;
import app.core.repository.GradesRepository;
import app.core.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private GradesRepository gradesRepository;

	public Student addStudent(Student student) {
		if (!this.studentRepository.existsByName(student.getName())) {
			this.studentRepository.save(student);
			return student;
		} else {
			throw new SchoolSystemException(
					"addStudent failed - a student with this name " + student.getName() + " already exists: ");
		}
	}
	public Grade addGrade(Grade grade) {
		return this.gradesRepository.save(grade);
	}
	
	/**
	 * @param studentId
	 * @throws SchoolSystemException if specified student not found
	 */
	public void deleteStudentById(int studentId) throws SchoolSystemException {
		if (this.studentRepository.existsById(studentId)) {
			this.studentRepository.deleteById(studentId);
		} else {
			throw new SchoolSystemException("deleteStudentById failed - id " + studentId + " not found");
		}
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(int studentId) throws SchoolSystemException {
		return this.studentRepository.findById(studentId)
				.orElseThrow(() -> new SchoolSystemException("get getStudentById failed -  id " + studentId + " not found"));
	}
	
	public Student updateStudent(Student student) throws SchoolSystemException {
		if (this.studentRepository.existsById(student.getId())) {
			return this.studentRepository.save(student);
		} else {
			throw new SchoolSystemException("updateStudent failed - student " + student.getName() + " not found");
		}
	}
	
	public float getStudentAverageById(int studentId) throws SchoolSystemException {
		Student student = getStudentById(studentId);
		List<Grade> grades = student.getGrades();
		int sum = 0;
		for (Grade grade : grades) {
			sum += grade.getScore();
		}
		return sum/3;
	}
}
