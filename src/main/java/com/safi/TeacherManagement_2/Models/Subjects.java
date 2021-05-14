package com.safi.TeacherManagement_2.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Subjects {
	@Id
	@SequenceGenerator(name="subject_id_sequence",sequenceName="subject_id_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="subject_id_sequence")
	@Column(name="subject_id",updatable=false)
	long subId;
	@Column(name="subject_name",nullable=false,updatable=false)
	String subName;
	
	@ManyToMany(
			//fetch=FetchType.LAZY
		//	cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			targetEntity=Students.class
			)
	@JoinTable(name="STUDENTS_SUBJECTS"
//	,referencedColumnName="stId"
	,joinColumns=@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	,inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
	)
	Set<Students> students=new HashSet<>();
	
	@OneToMany(mappedBy="subjects",fetch=FetchType.LAZY)
//	(targetEntity=Teacher.class,mappedBy="subjects",cascade=CascadeType.ALL)
//	@JoinColumn(referencedColumnName="teacher_id")
//	@Transient
	@JsonIgnore
	Set<Teacher> teachers=new HashSet<>();
	
	public Set<Teacher> getTeachers() { return teachers; } 
	public void setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }
	
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	/*
	 * public Set<Teacher> getTeachers() { return teachers; } public void
	 * setTeachers(Set<Teacher> teachers) { this.teachers = teachers; }
	 */
	public long getSubId() {
		return subId;
	}
	public void setSubId(long subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
}
