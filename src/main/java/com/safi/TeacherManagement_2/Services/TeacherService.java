package com.safi.TeacherManagement_2.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement_2.Models.Students;
import com.safi.TeacherManagement_2.Models.Subjects;
import com.safi.TeacherManagement_2.Models.Teacher;
import com.safi.TeacherManagement_2.Repositories.StudentRepository;
import com.safi.TeacherManagement_2.Repositories.SubjectRepository;
import com.safi.TeacherManagement_2.Repositories.TeacherRepository;

@Component
public class TeacherService implements MethodContainer {

	@Autowired
	TeacherRepository tRepo;
	
	@Autowired
	StudentRepository sRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
//	@Autowired
//	Subjects subs;
	
	@Override
	public Teacher addNewTeacher(@RequestBody Teacher teacher) {
		// TODO Auto-generated method stub
	//	return null;
		Teacher current_teacher=tRepo.save(teacher);
	//	long highest_id=current_teacher.gettId();
	//	System.out.println("Highest Teacher Id => "+highest_id);
		return teacher;
	}
	
	@Override
	public Students addNewStudent(@RequestBody Students student) {
		// TODO Auto-generated method stub
	//	return null;
		Students current_student=sRepo.save(student);
		long highest_id=current_student.getStId();
		System.out.println("Highest Student Id => "+highest_id);
		return student;
	}
	
	@Override
	public Teacher showOneTeacherDetails(int tid) {
		// TODO Auto-generated method stub
	//	return null;
		Teacher teacher=tRepo.findById((long) tid).orElse(new Teacher());
		return teacher;
	}

	@Override
	public String removeTeacher(long tid) {
		// TODO Auto-generated method stub
	//	return null;
		try {
			Teacher t=tRepo.getOne(tid);
			tRepo.delete(t);
			return "Teacher \n"+t+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}

	@Override
	public List<Teacher> showAllTeachers() {
		// TODO Auto-generated method stub
	//	return null;
		List<Teacher> teachers=tRepo.findAll();
		/*
		 * List<String> names=new ArrayList<>();
		 * teachers.forEach((t)->names.add(t.getName())); List<String> subjects=new
		 * ArrayList<>(); teachers.forEach((t)->subjects.add(t.getSubject()));
		 */
		return teachers;
	}

	@Override
	public String totalTeacherCount() {
		// TODO Auto-generated method stub
	//	return null;
		long c=tRepo.count();
		return "Total Number Of Teachers : "+c;
	}

	@Override
	public Subjects addNewSubject(Subjects subject) {
		// TODO Auto-generated method stub
		//return null;
		return subRepo.save(subject);
	}

	@Override
	public Subjects showOneSubDetails(int tid) {
		// TODO Auto-generated method stub
	//	return null;
	//	Subjects subject=subRepo.getOne((long) tid);
		Subjects subject=subRepo.findById((long)tid).orElse(new Subjects());
	//	Set<Teacher> teachers=tRepo.getAllRelatedTeachers(tid);
//		subject.setTeachers(teachers);
	//	subject.setTeachers(teachers);
	//	System.out.println("Result => "+tRepo.findAll());
	//	System.out.println("Result Type => "+tRepo.findAll().get(0).getClass().getName());
		
	//	System.out.println("Result_2 => "+subRepo.findAll());
	//	System.out.println("Result_2 Type => "+subRepo.findAll().get(0).getClass().getName());
		
//		System.out.println("Result => "+tRepo.getAllRelatedTeachers(tid));
//		System.out.println("Result Type => "+tRepo.getAllRelatedTeachers(tid).get(0).getClass().getName());
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Subject => "+subject.getSubName());
		
		Set<Teacher> teachers=(Set<Teacher>) subject.getTeachers();
		for(Teacher teacher:teachers) {
			System.out.println("Teacher -->> "+teacher.getName());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		return subject;
	}

	@Override
	public Students showOneStudentDetails(int tid) {
		// TODO Auto-generated method stub
		Students student=sRepo.findById((long)tid).orElse(null);
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Student => "+student.getName());
		
		Set<Subjects> subjects=(Set<Subjects>) student.getSubjects();
		for(Subjects subject:subjects) {
			System.out.println("Subject -->> "+subject.getSubName());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
		return student;
	}

	@Override
	public String removeStudent(long tid) {
		// TODO Auto-generated method stub
		try {
			Students s=sRepo.getOne(tid);
			sRepo.delete(s);
			return "Student \n"+s+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}

	@Override
	public String removeSubject(long tid) {
		// TODO Auto-generated method stub
		try {
			Subjects s=subRepo.getOne(tid);
			subRepo.delete(s);
			return "Subject \n"+s+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}

	@Override
	public List<Students> showAllStudents() {
		// TODO Auto-generated method stub
		List<Students> students=sRepo.findAll();
		return students;
	}

	@Override
	public List<Subjects> showAllSubjects() {
		// TODO Auto-generated method stub
		List<Subjects> subjects=subRepo.findAll();
		return subjects;
	}

	@Override
	public String totalStudentsCount() {
		// TODO Auto-generated method stub
		long c=sRepo.count();
		return "Total Number Of Students : "+c;
	}

	@Override
	public String totalSubjectsCount() {
		// TODO Auto-generated method stub
		long c=subRepo.count();
		return "Total Number Of Subjects : "+c;
	}

}
