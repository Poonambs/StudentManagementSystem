package com.poonam.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poonam.dao.Studentdao;
import com.poonam.entity.Student;
import com.poonam.service.StudentService;

@Component
public class StudentServiceImpl implements StudentService{
@Autowired
Studentdao dao;
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.addStudent(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

	@Override
	public String deleteStudent(long id) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(id);
	}

	@Override
	public int updateStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.updateStudent(student);
	}
	

}
