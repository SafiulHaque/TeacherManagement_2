package com.safi.TeacherManagement_2.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.safi.TeacherManagement_2.Models.Subject;
import com.safi.TeacherManagement_2.Models.Teacher;
import com.safi.TeacherManagement_2.Repositories.SubjectRepository;

public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subRepo;
	
	@Override
	public Subject addNewSubject(Subject subject) {
		// TODO Auto-generated method stub
		//return null;
		return subRepo.save(subject);
	}

	@Override
	public Subject showOneSubDetails(int tid) {
		// TODO Auto-generated method stub
	//	return null;
	//	Subject subject=subRepo.getOne((long) tid);
		Subject subject=subRepo.findById((long)tid).orElse(new Subject());
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
	public String removeSubject(long tid) {
		// TODO Auto-generated method stub
		try {
			Subject s=subRepo.getOne(tid);
			subRepo.delete(s);
			return "Subject \n"+s+"\nDeleted Successfully";
		}
		catch(Exception e) {
			return "Excception -> "+e.getMessage();
		}
	}

	@Override
	public String totalSubjectsCount() {
		// TODO Auto-generated method stub
		long c=subRepo.count();
		return "Total Number Of Subject : "+c;
	}

	@Override
	public String updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		Subject subj=subRepo.save(subject);
		return "Subject \n"+subj.getSubId()+" -> "+subj.getSubName()+"\nUpdated Successfully";
	}
	
	@Override
	public List<Subject> showAllSubjects() {
		// TODO Auto-generated method stub
		List<Subject> subject=subRepo.findAll();
		return subject;
	}
}
