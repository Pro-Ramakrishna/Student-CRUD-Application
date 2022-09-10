package com.ram.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ram.model.Student;
import com.ram.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService stdService;
	
	@PostMapping("/save")
	public String saveData(@RequestBody Student studentModel) {
		Student student2=stdService.saveStudent(studentModel);
		String message=null;
		if(student2!=null) {
			message="student saved sucessfully in database";
		}
		else {
			message="student not save in database";
		}
		return message;
	}
	@PutMapping("/update/{stdId}")
	public Student updateStudent(@RequestBody Student studentModel,
			@PathVariable Integer stdId) {
		
		Student studentResposne=stdService.getStudent(stdId);
		Student student = new Student();
		student.setStdId(stdId);
		student.setStdName(studentModel.getStdName());
		student.setStdClass(studentModel.getStdClass());
		student.setMarks(studentModel.getMarks());
		Student student2=stdService.updateStudent(student);
		return student2;
	}
	@GetMapping("/get/{stdId}")
	public Student findById(@PathVariable Integer stdId) {
		Student student = stdService.getStudent(stdId);
		Student studentModel = new Student();
		
		if (student != null) {
			BeanUtils.copyProperties(student, studentModel);
		}
		return studentModel;
	}

	@DeleteMapping("/delete/{stdId}")
	public void deleteStudent(@PathVariable Integer stdId) {
		stdService.deleteStudent(stdId);
	}	

	@GetMapping("/getAll")
	public List<Student> findAll() {
		List<Student> studentList = stdService.getAllStudent();
		List<Student> stdentModelList=new ArrayList<>();
		Student studentModel = null;
		for(Student entity:studentList) {
			Student model=new Student();
			BeanUtils.copyProperties(entity, model);
			stdentModelList.add(model);
		}
		return stdentModelList;
	
}
}
