package com.school.management.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.school.management.dto.ResponseDTO;
import com.school.management.entity.Teacher;
import com.school.management.repository.TeacherRepository;
import com.school.management.util.Constants;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private ResponseDTO responseDto;

	public ResponseDTO createTeacher(Teacher teacher) {
		responseDto.setMessage(Constants.CREATED);
		responseDto.setData(teacherRepo.save(teacher));
		responseDto.setStatusCode(200);
		return responseDto;
	}

	//get all teacher
	public ResponseDTO getAllTeacher() {
		responseDto.setMessage(Constants.RETRIEVED);
		responseDto.setData(teacherRepo.findAll());
		responseDto.setStatusCode(200);
		return responseDto;
	}

	
	//put
	public ResponseDTO updateTeacher(long id, Teacher teacher) {
		Teacher t=teacherRepo.findById(id).orElseThrow(null);
		t.setName(teacher.getName());
		t.setSalary(teacher.getSalary());
		t.setSchool(teacher.getSchool());
		t.setSubject(teacher.getSubject());

		responseDto.setMessage(Constants.MODIFIED);
		responseDto.setData(teacherRepo.save(t));
		responseDto.setStatusCode(200);
		return responseDto;
	}

	
	//delete
	public ResponseDTO dropTeacher(long id) {
		teacherRepo.deleteById(id);
		responseDto.setMessage(Constants.REMOVED);
		responseDto.setStatusCode(200);
		return responseDto;
	}

	
	//get All teacherBy schoolID
	public ResponseDTO getAllTeacherBySchool(Long schoolId) {
	
		 responseDto.setMessage(Constants.RETRIEVED);
		 responseDto.setData(teacherRepo.findAllBySchoolId(schoolId));
		 responseDto.setStatusCode(200);
		 return responseDto;
	}

	
	//getTeacherById
	public ResponseDTO getTeacherById(long id) {
		 responseDto.setMessage(Constants.RETRIEVED);
		 responseDto.setData(teacherRepo.findById(id));
		 responseDto.setStatusCode(200);
		 return responseDto;
		
	}



//    public ResponseDTO searchTeachers(String name, int page, int size) {
//        PageRequest pageable = PageRequest.of(page, size);
//        Page<Teacher> teachers=teacherRepo.findByNameContaining(name,pageable,Sort.by(Sort.Direction.ASC));
//        responseDto.setMessage(Constants.RETRIEVED);
//		responseDto.setData(teachers);
//		responseDto.setStatusCode(200);
//		return responseDto;
//    }

	
}
