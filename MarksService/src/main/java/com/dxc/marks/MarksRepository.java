package com.dxc.marks;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.marks.model.Marks;


//not needed for hard coded values
public interface MarksRepository extends JpaRepository<Marks, Integer>{

}
