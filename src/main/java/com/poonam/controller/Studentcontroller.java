package com.poonam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.poonam.entity.Student;
import com.poonam.exception.ResourceNotExistsException;
import com.poonam.service.StudentService;

@RestController
@RequestMapping("/student")
public class Studentcontroller {
	@Autowired
	StudentService service;
	
	@PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = service.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }
	@GetMapping("/get-all-students")
	public ResponseEntity<List<Student>> getAllProducts() {

		List<Student> studList = service.getAllStudents();
		if (!studList.isEmpty()) {
			return new ResponseEntity<List<Student>>(studList, HttpStatus.OK);
		} else {
			throw new ResourceNotExistsException("Student Not Exists, List Is Empty");
		}

	}

	@DeleteMapping("/delete-student-by-id")
	public ResponseEntity<String> deleteStudent(@RequestParam long id) {

		service.deleteStudent(id);

		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.MOVED_PERMANENTLY);

	}@PutMapping("/update-student")
	public ResponseEntity<String> updateUpdateStudenr(@RequestBody Student student) {

		int status = service.updateStudent(student);
		if (status == 1) {
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);

		} else {
			throw new ResourceNotExistsException("Student ID Not Exists");


		}

	
	

	}}
