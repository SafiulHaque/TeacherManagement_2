package com.safi.TeacherManagement_2.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement_2.Models.Student;
import com.safi.TeacherManagement_2.Models.Subject;
import com.safi.TeacherManagement_2.Repositories.StudentRepository;

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository sRepo;

	@Override
	public Student addNewStudent(@RequestBody Student student) {
		// TODO Auto-generated method stub
	//	return null;
		Student current_student=sRepo.save(student);
		long highest_id=current_student.getStId();
		System.out.println("Highest Student Id => "+highest_id);
		return student;
	}
	
	@Override
	public Student showOneStudentDetails(int tid) {
		// TODO Auto-generated method stub
		Student student=sRepo.findById((long)tid).orElse(null);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Student => "+student.getName());
		
		Set<Subject> subjects=(Set<Subject>) student.getSubjects();
		for(Subject subject:subjects) {
			System.out.println("Subject -->> "+subject.getSubName());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		return student;
	}
	
	@Override
	public String removeStudent(long tid) {
		// TODO Auto-generated method stub
		try {
			Student s=sRepo.getOne(tid);
			sRepo.delete(s);
			return "Student \n"+s+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}
	
	@Override
	public List<Student> showAllStudents() {
		// TODO Auto-generated method stub
		List<Student> student=sRepo.findAll();
		return student;
	}
	
	@Override
	public String totalStudentsCount() {
		// TODO Auto-generated method stub
		long c=sRepo.count();
		return "Total Number Of Student : "+c;
	}
	
	@Override
	public String updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student s=sRepo.save(student);
		return "Student \n"+s.getStId()+" -> "+s.getName()+"\nUpdated Successfully";
	}
}
