package com.dxc.student.resource;


import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.student.StudentRepository;
import com.dxc.student.model.Student;

@RestController
@RequestMapping("/student")
public class StudentResource {

	//obtaining data from the Database
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("/{id}")
	public Student getStudent(@PathVariable("id") int studid) {
	    Student student = (Student)studentRepository.findById(studid).orElse(new Student());
		return student;
	}
	
	//Hardcoded Values
//	@RequestMapping("/{id}")
//	public Student getStudent(@PathVariable("id") int studid) {
//		Map<Integer, Student> students = new HashMap<>();
//		students.put(101, new Student(101,"karthik"));
//		students.put(102, new Student(102,"sai"));
//    return students.get(studid);
//	}
}
