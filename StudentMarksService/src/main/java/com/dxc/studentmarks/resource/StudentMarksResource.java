package com.dxc.studentmarks.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.studentmarks.model.Marks;
import com.dxc.studentmarks.model.Student;
import com.dxc.studentmarks.model.StudentMarks;

@RestController
@RequestMapping("/studentmarks")
public class StudentMarksResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{id}")
	public StudentMarks getStudentMarks(@PathVariable("id") int studid) {
		
		//Obtain Student data from it's webservice : http://localhost:8181/student/{id}
		
//		Map<Integer, Student> students = new HashMap<>();
//		students.put(101, new Student(101,"karthik"));
//		students.put(102, new Student(102,"sai"));
		
//		RestTemplate restTemplate = new RestTemplate();
		Student student = restTemplate.getForObject("http://student-service/student/"+studid, Student.class);
		
		//Obtain Marks data from it's webservice : http://localhost:8282/marks/{id}
		
//		List<Marks> marks = Arrays.asList(
//				new Marks(101,801,89,89),
//				new Marks(101,802,78,78),
//				new Marks(102,801,99,88),
//				new Marks(102,802,77,99)
//				);
		Marks[] marks = restTemplate.getForObject("http://marks-service/marks/"+studid, Marks[].class);
		
		
		//Bring student data and marks data and combine
		return new StudentMarks(student.getName(),
				Arrays.asList(marks)
//				return new StudentMarks(students.get(studid).getName(),
//				marks.stream()
//				.filter(mark -> mark.getStudid() ==studid)
//				.collect(Collectors.toList())
				);
	}
}
