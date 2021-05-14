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
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Students {
	@Id
	@SequenceGenerator(name="student_id_sequence",sequenceName="student_id_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="student_id_sequence")
	@Column(name="student_id",nullable=false,updatable=false)
	long stId;
	String name;
	int standard;
	int roll;
	
	
	public Students() { super(); }
	
	@ManyToMany(
	//		cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
	//		,mappedBy="students",fetch=FetchType.LAZY
			targetEntity=Subjects.class
			)
//	@JoinColumn(name="students_subjects",referencedColumnName="subject_id")
	@JoinTable(name="STUDENTS_SUBJECTS"
	,joinColumns=@JoinColumn(name="student_id",referencedColumnName="student_id")
	,inverseJoinColumns=@JoinColumn(name="subject_id",referencedColumnName="subject_id")
	)
	@JsonProperty(access = Access.WRITE_ONLY)
	Set<Subjects> subjects=new HashSet<>();
	
	
	
	
	public Set<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public Students(long stId, String name, int standard, int roll) { super();
	this.stId = stId; this.name = name; this.standard = standard; this.roll = roll;
	}
	
	public Students(long stId, String name, int standard, int roll, Set<Subjects>
	subjects) { super(); this.stId = stId; this.name = name; this.standard =
	standard; this.roll = roll; this.subjects = subjects; }
	
	
	
	public long getStId() {
		return stId;
	}

	public void setStId(long stId) {
		this.stId = stId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
}
