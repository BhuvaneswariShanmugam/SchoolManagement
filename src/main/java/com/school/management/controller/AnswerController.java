package com.school.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.management.dto.AnswerDTO;
import com.school.management.dto.ResponseDTO;
import com.school.management.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
	
	
	@PostMapping("/")
	public ResponseDTO createAnswer(@RequestBody List<AnswerDTO> answerDto)
	{   
	   return answerService.createAnswer(answerDto);
		
	}
	

	//get all answer for student
	@GetMapping("/")
	public ResponseDTO getAllAnswer(){
		return answerService.getAllAnswer();
	}
	
	
	//get all answer by studentID
	@GetMapping("/{studentId}")
	public ResponseDTO getAllAnswerByStudentId(@PathVariable Long studentId){
		return answerService.getAllAnswerByStudentId(studentId);
	}
	

	//get all answer by studentID and subjectID
	@GetMapping("/{studentId}/{subjectId}")
	public ResponseDTO getAllAnswerByStudentIdAndSubjectId(@PathVariable Long studentId,@PathVariable Long subjectId){
		return answerService.getAllAnswerByStudentIdAndSubjectId(studentId,subjectId);
	}
	
	
	
	//get mark by subject 
	@GetMapping("/submark/{studentId}/{subjectId}")
	public Integer getMarkBySubjectId(@PathVariable Long studentId,@PathVariable Long subjectId){
		 return answerService.getMarkBySubjectId(studentId,subjectId);
		 
			 
	}
	
	//get Total MarkBy studentID
	@GetMapping("/totalmark/{studentId}")
	public Integer getTotalMarkByStudentId(@PathVariable Long studentId) {
		return answerService.getTotalMarkByStudentId(studentId);
	}
	
}
