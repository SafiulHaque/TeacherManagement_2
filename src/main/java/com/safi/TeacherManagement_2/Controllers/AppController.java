package com.safi.TeacherManagement_2.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safi.TeacherManagement_2.Models.Student;
import com.safi.TeacherManagement_2.Models.Subject;
import com.safi.TeacherManagement_2.Models.Teacher;
import com.safi.TeacherManagement_2.Services.StudentService;
import com.safi.TeacherManagement_2.Services.SubjectService;
import com.safi.TeacherManagement_2.Services.TeacherService;

@RestController
public class AppController {
	@Autowired
	TeacherService teacerService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	SubjectService subjectService;
	
//	@Autowired
//	TeacherService service;
	
	@PutMapping("/addNewTeacher")
	public Teacher addNewTeacher(@RequestBody Teacher teacher) {
		return teacerService.addNewTeacher(teacher);
	}
	
	@PutMapping("/addNewStudent")
	public Student addNewStudent(@RequestBody Student student) {
		return studentService.addNewStudent(student);
	}
	
	@PutMapping("/addNewSubject")
	public Subject addNewSubject(@RequestBody Subject subject) {
		return subjectService.addNewSubject(subject);
	}
	
	@GetMapping(value="/details/teacher/{id}")
	public Teacher showOneTeacherDetails(@PathVariable("id") int tid) {
		return teacerService.showOneTeacherDetails(tid);
	}
	
	@GetMapping(value="/details/subject/{id}")
	public Subject showOneSubjectDetails(@PathVariable("id") int tid) {
		return subjectService.showOneSubDetails(tid);
	}
	
	@GetMapping(value="/details/student/{id}")
	public Student showOneStudentDetails(@PathVariable("id") int tid) {
		return studentService.showOneStudentDetails(tid);
	}
	
	@DeleteMapping(value="/removeTeacher/{id}")
	public String removeTeacher(@PathVariable("id") int tid) {
		return teacerService.removeTeacher(tid);
	}
	
	@DeleteMapping(value="/removeStudent/{id}")
	public String removeStudent(@PathVariable("id") int tid) {
		return studentService.removeStudent(tid);
	}
	
	@DeleteMapping(value="/removeSubject/{id}")
	public String remove(@PathVariable("id") int tid) {
		return subjectService.removeSubject(tid);
	}
	
	@GetMapping(value="/teachers")
	public List<Teacher> showAllTeachers() {
		return teacerService.showAllTeachers();
	}
	
	@GetMapping(value="/student")
	public List<Student> showAllStudents() {
		return studentService.showAllStudents();
	}
	
	@GetMapping(value="/subject")
	public List<Subject> showAllSubjects() {
		return subjectService.showAllSubjects();
	}
	
	@GetMapping(value="/teacherCount")
	public String totalTeacherCount() {
		return teacerService.totalTeacherCount();
	}
	
	@GetMapping(value="/studentCount")
	public String totalStudentCount() {
		return studentService.totalStudentsCount();
	}
	
	@GetMapping(value="/subjectCount")
	public String totalSubjectCount() {
		return subjectService.totalSubjectsCount();
	}
	
	@PutMapping(value="/update/subject")
	public String updateSubject(@RequestBody Subject subject) {
		return subjectService.updateSubject(subject);
	}
	
	@PutMapping(value="/update/teacher")
	public String updateTeacher(@RequestBody Teacher teacher) {
		return teacerService.updateTeacher(teacher);
	}
	
	@PutMapping(value="/update/student")
	public String updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
}
