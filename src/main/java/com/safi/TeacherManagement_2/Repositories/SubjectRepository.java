package com.safi.TeacherManagement_2.Repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safi.TeacherManagement_2.Models.Subjects;
import com.safi.TeacherManagement_2.Models.Teacher;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {
	
//	@Query(value="SELECT * FROM TEACHER_2 WHERE SUBJECTS_SUBJECT_ID=2",nativeQuery=true)
//	public List<Teacher> getAllRelatedTeachers(int id);

}
