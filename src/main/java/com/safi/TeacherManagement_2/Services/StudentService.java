package com.safi.TeacherManagement_2.Services;

import java.util.List;

import com.safi.TeacherManagement_2.Models.Student;

public interface StudentService {
	public Student addNewStudent(Student student);
	public Student showOneStudentDetails(int tid);
	public List<Student> showAllStudents();
	public String removeStudent(long tid);
	public String updateStudent(Student student);
	public String totalStudentsCount();
}
