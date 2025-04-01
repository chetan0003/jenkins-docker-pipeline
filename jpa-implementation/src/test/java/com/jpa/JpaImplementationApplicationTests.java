package com.jpa;

import com.jpa.entities.CourseDetail;
import com.jpa.entities.StudentDetail;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest
class JpaImplementationApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	@Test
	@Transactional
	void contextLoads() {

		Example<CourseDetail> example = Example.of(new CourseDetail());
		//List<CourseDetail> all2 = courseRepository.findAll(example);
		Optional<CourseDetail> byId = courseRepository.findById(1L);
		Optional<StudentDetail> byId1 = studentRepository.findById(1L);
		//System.out.println(byId.get().getStudentDetail().getId());
		StudentDetail studentDetail = byId.get().getStudentDetail();
		System.out.println(byId.get().getStudentDetail());
		System.out.println(byId.get().getStudentDetail().getName());
		System.out.println(byId.get().getStudentDetail().getPhone());

	}
	}


