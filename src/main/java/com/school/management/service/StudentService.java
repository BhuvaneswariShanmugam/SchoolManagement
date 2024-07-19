package com.school.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.management.dto.ResponseDTO;
import com.school.management.entity.Student;
import com.school.management.repository.StudentRepository;
import com.school.management.util.Constants;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ResponseDTO responseDto;

	public ResponseDTO createStudent(Student student) {
		responseDto.setMessage(Constants.CREATED);
		responseDto.setData(studentRepo.save(student));
		responseDto.setStatusCode(200);
		return responseDto;
	}

	public ResponseDTO getAllStudent() {
		responseDto.setMessage(Constants.RETRIEVED);
		responseDto.setData(studentRepo.findAll());
		responseDto.setStatusCode(200);
		return responseDto;
		
	}

	public ResponseDTO updateStudent(Long id, Student student) {
		
		Student obj=studentRepo.findById(id).orElseThrow(null);
		
		obj.setName(student.getName());
		obj.setStandard(student.getStandard());
		obj.setFee(student.getFee());
		obj.setSchool(student.getSchool());
		
		responseDto.setMessage(Constants.MODIFIED);
		responseDto.setData(studentRepo.save(obj));
		responseDto.setStatusCode(200);
		return responseDto;
	}

	public ResponseDTO dropStudent(Long id) {
		studentRepo.deleteById(id);
		responseDto.setMessage(Constants.REMOVED);
		responseDto.setStatusCode(200);
		return responseDto;
	}

	public ResponseDTO getAllStudentByStandard(String standard) {
		responseDto.setMessage(Constants.RETRIEVED);
		responseDto.setData(studentRepo.findAllByStandard(standard));
		responseDto.setStatusCode(200);
		return responseDto;
	}

	
}
