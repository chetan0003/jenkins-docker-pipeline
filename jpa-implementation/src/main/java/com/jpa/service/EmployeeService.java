package com.jpa.service;

import com.jpa.entities.Department;
import com.jpa.entities.Employee;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void getDepartment() {
        departmentRepository.findAll().forEach(o -> {
            System.out.println(o.getEmployees());
        });
    }

}
