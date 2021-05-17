package com.safi.TeacherManagement_2.Services;

import java.util.List;

import com.safi.TeacherManagement_2.Models.Subject;

public interface SubjectService {
	public Subject addNewSubject(Subject subject);
	public String removeSubject(long tid);
	public List<Subject> showAllSubjects();
	public String totalSubjectsCount();
	public Subject showOneSubDetails(int tid);
	public String updateSubject(Subject subject);
}
