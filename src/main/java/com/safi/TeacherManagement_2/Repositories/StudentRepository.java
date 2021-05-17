package com.safi.TeacherManagement_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safi.TeacherManagement_2.Models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
