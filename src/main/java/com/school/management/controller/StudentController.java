package com.school.management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.management.dto.ResponseDTO;
import com.school.management.entity.Student;
import com.school.management.repository.StudentRepository;
import com.school.management.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	@PostMapping("/create-student")
	public ResponseDTO createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
		
	}
	
	
	@GetMapping("/all-student")
	public ResponseDTO getAllStudent(){
		return studentService.getAllStudent();
	}
	
	
	@GetMapping("/student-by-std/{standard}")
	public ResponseDTO getAllStudentByStandard(@PathVariable String standard) {
		return studentService.getAllStudentByStandard(standard);
	}
	
	
	@PutMapping("/update-student/{id}")
	public ResponseDTO updateStudent(@PathVariable Long id,@RequestBody Student student)
	{
		return studentService.updateStudent(id,student);
		
	}
	
	@DeleteMapping("/remove-student/{id}")
	public ResponseDTO dropStudent(@PathVariable Long id) {
		return studentService.dropStudent(id);
		
	}
	
	

}
