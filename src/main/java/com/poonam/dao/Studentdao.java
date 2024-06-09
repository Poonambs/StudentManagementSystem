package com.poonam.dao;

import java.util.List;

import com.poonam.entity.Student;



public interface Studentdao {
	public Student addStudent(Student student);
	public List<Student> getAllStudents();
	public String deleteStudent(long StudentId);
	public int updateStudent(Student student);

}
