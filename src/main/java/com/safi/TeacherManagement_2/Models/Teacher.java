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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.safi.TeacherManagement_2.Repositories.SubjectRepository;

@Entity
@Table(name="Teacher_2")
public class Teacher {
	@Id
	@SequenceGenerator(name="teacher2_id_sequence",sequenceName="teacher2_id_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="teacher2_id_sequence")
	@Column(name="teacher_id",nullable=false,updatable=false)
	long tid;
	String name;
	int age;
//	String subject;
	
	@ManyToOne
//	(cascade=CascadeType.MERGE)
	//(targetEntity=Subjects.class)
//	@JoinColumn(name="SUBJECTS_SUBJECT_ID",referencedColumnName="subject_id")
	//(mappedBy="teachers")
//	Set<Subjects> subjects=new HashSet<>();
//	@Autowired
	Subjects subjects;
	
//	@Autowired
//	@Transient
//	SubjectRepository subRepo;
	
	/*
	 * public Teacher(long tid, String name, int age, String subject, Set<Subjects>
	 * subjects) { super(); this.tid = tid; this.name = name; this.age = age;
	 * this.subject = subject; this.subjects = subjects; } public Teacher() {
	 * super(); } public Teacher(int tid, String name, int age, String subject) {
	 * super(); this.tid = tid; this.name = name; this.age = age; this.subject
	 * =subject; }
	 */
	
	public 
//	Set<Subjects> 
	Subjects
	getSubjects() {
		return subjects;
	}
	public void setSubjects(
		//	Set<Subjects>
			Subjects
			subjects
		//	long id
			) {
	//	long id=subjects.getSubId();
		this.subjects = subjects;
	//	Subjects sub=subRepo.getOne(id);
	//	this.subjects=sub;
	}
	
	
	
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	/*
	 * public String getSubject() { return subject; } public void setSubject(String
	 * subject) { this.subject = subject; }
	 */
	
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", age=" + age + ", subject=" + subjects + "]";
	}
}
