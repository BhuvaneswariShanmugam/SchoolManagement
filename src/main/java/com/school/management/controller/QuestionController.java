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
import com.school.management.entity.Question;
import com.school.management.service.QuestionService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/")
	public ResponseDTO createQuestion(@RequestBody Question question) {
		return questionService.createQuestion(question);

	}

	
	// getAllQuestionWithAnswer
	@GetMapping("/")
	public ResponseDTO getAllQuestion(){
		return questionService.getAllQuestion();
	}
	
	//getAllQuestionOnleBySubjectId
	@GetMapping("/{subjectId}")
	public ResponseDTO getAllQuestionOnly(@PathVariable Long subjectId){
		return questionService.getAllQuestionOnly(subjectId);
	}
	
	
	@PutMapping("/{id}")
	public ResponseDTO updateQuestion(@PathVariable Long id,@RequestBody Question question) {
		return questionService.updateQuestion(id,question);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseDTO dropQuestion(@PathVariable Long id) {
		 return 
				 questionService.dropQuestion(id);
		 
	}
	
	


}
