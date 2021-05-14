package com.safi.TeacherManagement_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safi.TeacherManagement_2.Models.Students;

public interface StudentRepository extends JpaRepository<Students, Long> {

}
