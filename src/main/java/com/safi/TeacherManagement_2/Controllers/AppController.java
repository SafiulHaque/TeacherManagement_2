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

import com.safi.TeacherManagement_2.Models.Students;
import com.safi.TeacherManagement_2.Models.Subjects;
import com.safi.TeacherManagement_2.Models.Teacher;
import com.safi.TeacherManagement_2.Services.MethodContainer;
import com.safi.TeacherManagement_2.Services.TeacherService;

@RestController
public class AppController {
	@Autowired
	MethodContainer container;
	
//	@Autowired
//	TeacherService service;
	
	@PutMapping("/addNewTeacher")
	public Teacher addNewTeacher(@RequestBody Teacher teacher) {
		return container.addNewTeacher(teacher);
	}
	
	@PutMapping("/addNewStudent")
	public Students addNewStudent(@RequestBody Students student) {
		return container.addNewStudent(student);
	}
	
	@PutMapping("/addNewSubject")
	public Subjects addNewSubject(@RequestBody Subjects subject) {
		return container.addNewSubject(subject);
	}
	
	@GetMapping(value="/details/teacher/{id}")
	public Teacher showOneTeacherDetails(@PathVariable("id") int tid) {
		return container.showOneTeacherDetails(tid);
	}
	
	@GetMapping(value="/details/subject/{id}")
	public Subjects showOneSubjectDetails(@PathVariable("id") int tid) {
		return container.showOneSubDetails(tid);
	}
	
	@GetMapping(value="/details/student/{id}")
	public Students showOneStudentDetails(@PathVariable("id") int tid) {
		return container.showOneStudentDetails(tid);
	}
	
	@DeleteMapping(value="/removeTeacher/{id}")
	public String removeTeacher(@PathVariable("id") int tid) {
		return container.removeTeacher(tid);
	}
	
	@DeleteMapping(value="/removeStudent/{id}")
	public String removeStudent(@PathVariable("id") int tid) {
		return container.removeStudent(tid);
	}
	
	@DeleteMapping(value="/removeSubject/{id}")
	public String remove(@PathVariable("id") int tid) {
		return container.removeSubject(tid);
	}
	
	@GetMapping(value="/teachers")
	public List<Teacher> showAllTeachers() {
		return container.showAllTeachers();
	}
	
	@GetMapping(value="/students")
	public List<Students> showAllStudents() {
		return container.showAllStudents();
	}
	
	@GetMapping(value="/subjects")
	public List<Subjects> showAllSubjects() {
		return container.showAllSubjects();
	}
	
	@GetMapping(value="/teacherCount")
	public String totalTeacherCount() {
		return container.totalTeacherCount();
	}
	
	@GetMapping(value="/studentCount")
	public String totalStudentCount() {
		return container.totalStudentsCount();
	}
	
	@GetMapping(value="/subjectCount")
	public String totalSubjectCount() {
		return container.totalSubjectsCount();
	}
}
