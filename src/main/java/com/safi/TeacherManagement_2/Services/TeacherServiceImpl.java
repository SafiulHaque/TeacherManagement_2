package com.safi.TeacherManagement_2.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.safi.TeacherManagement_2.Models.Student;
import com.safi.TeacherManagement_2.Models.Subject;
import com.safi.TeacherManagement_2.Models.Teacher;
import com.safi.TeacherManagement_2.Repositories.StudentRepository;
import com.safi.TeacherManagement_2.Repositories.SubjectRepository;
import com.safi.TeacherManagement_2.Repositories.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository tRepo;
	
//	@Autowired
//	Subject subs;
	
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
		 * teachers.forEach((t)->names.add(t.getName())); List<String> subject=new
		 * ArrayList<>(); teachers.forEach((t)->subject.add(t.getSubject()));
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
	public String updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Teacher t=tRepo.save(teacher);
		return "Teacher \n"+t.getTid()+" -> "+t.getName()+"\nUpdated Successfully";
	}

}
