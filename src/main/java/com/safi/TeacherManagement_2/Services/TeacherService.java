package com.safi.TeacherManagement_2.Services;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement_2.Models.Student;
import com.safi.TeacherManagement_2.Models.Subject;
import com.safi.TeacherManagement_2.Models.Teacher;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public interface TeacherService {
	
	public Teacher addNewTeacher(Teacher teacher);
	
	public Teacher showOneTeacherDetails(int tid);
	
	public String removeTeacher(long tid);
	
	public List<Teacher> showAllTeachers();
	
	public String totalTeacherCount();
	
	public String updateTeacher(Teacher teacher);
	
}
