package com.school.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.school.management.entity.Teacher;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long>{

	List<Teacher> findAllBySchoolId(Long schoolId);

}

