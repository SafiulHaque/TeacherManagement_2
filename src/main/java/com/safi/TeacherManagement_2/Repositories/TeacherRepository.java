package com.safi.TeacherManagement_2.Repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safi.TeacherManagement_2.Models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	@Query(value="SELECT MAX(TID) FROM Teacher", nativeQuery = true)
	public long getHighestId();
	
	public Teacher getByNameOrderByDesc(String name);
	
	/*
	 * @Query(value="SELECT * FROM Teacher", nativeQuery = true) public
	 * List<Teacher> getAllDetails();
	 */
	
	@Query(value="SELECT * FROM TEACHER_2 WHERE SUBJECTS_SUBJECT_ID=?",nativeQuery=true)
	public Set<Teacher> getAllRelatedTeachers(int id);
}
