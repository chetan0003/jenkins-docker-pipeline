package com.jpa;

import com.jpa.entities.CourseDetail;
import com.jpa.entities.StudentDetail;
import com.jpa.repository.CourseRepository;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.StudentRepository;
import com.jpa.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@SpringBootApplication
@Service
public class JpaImplementationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaImplementationApplication.class, args);
    }



    //@Bean
    @Transactional
    @Bean
    CommandLineRunner commandLineRunner(EmployeeService employeeService, DepartmentRepository departmentRepository
                                        ) {

        return args -> {
            employeeService.getDepartment();
            //employeeService.saveEmployee();
//            employeeService.getEmployee().forEach(o -> {
//                System.out.println(o);
//                System.out.println(o.getDepartment());
//            });




        };
    }

    void iterateStudent(List<StudentDetail> all1) {
        for (StudentDetail studentDetail : all1) {
            System.out.println(studentDetail.getId() + " " + studentDetail.getName());
            for (CourseDetail courseDetail : studentDetail.getCourseDetail()) {
                System.out.print(courseDetail.getId() + " " + courseDetail.getCourseName());
            }

        }
    }

}
