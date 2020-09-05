package com.dxc.marks.resource;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.marks.MarksRepository;
import com.dxc.marks.model.Marks;


@RestController
@RequestMapping("/marks")
public class MarksResource {
	
	//obtaining data from the Database(not completed : only returning single data)
//	@Autowired
//	MarksRepository marksRepository;
//	
//	@RequestMapping("/{id}")
//	public Marks getMarks(@PathVariable("id") int studid){
//	   Marks marks = (Marks)marksRepository.findById(studid).orElse(new Marks());
//		return marks;
//	}
 
	
	
	//Hardcoded Values
	@RequestMapping("/{id}")
	public List<Marks> getMarks(@PathVariable("id") int studid){
		List<Marks> marks = Arrays.asList(
				new Marks(101,801,89,89),
				new Marks(101,802,78,78),
				new Marks(102,801,99,88),
				new Marks(102,802,77,99)
				);
		
		return marks.stream().filter(mark -> mark.getStudid() == studid)
				.collect(Collectors.toList());
	}
}
