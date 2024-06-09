package com.poonam.service;

import java.util.List;

import com.poonam.entity.Student;

public interface StudentService {
	
		public Student addStudent(Student student);
		public List<Student> getAllStudents();
		public String deleteStudent(long StudentId);
		public int updateStudent(Student student);

}
