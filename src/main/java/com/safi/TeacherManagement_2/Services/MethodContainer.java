package com.safi.TeacherManagement_2.Services;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement_2.Models.Students;
import com.safi.TeacherManagement_2.Models.Subjects;
import com.safi.TeacherManagement_2.Models.Teacher;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface MethodContainer {
	
	public Teacher addNewTeacher(Teacher teacher);
	
	public Subjects addNewSubject(Subjects subject);
	
	public Teacher showOneTeacherDetails(int tid);
	
	public String removeTeacher(long tid);
	
	public String removeStudent(long tid);
	
	public String removeSubject(long tid);
	
	public List<Teacher> showAllTeachers();
	
	public List<Students> showAllStudents();
	
	public List<Subjects> showAllSubjects();
	
	public String totalTeacherCount();
	
	public String totalStudentsCount();
	
	public String totalSubjectsCount();

	Students addNewStudent(Students student);
	
	public Subjects showOneSubDetails(int tid);
	
	public Students showOneStudentDetails(int tid);
}
