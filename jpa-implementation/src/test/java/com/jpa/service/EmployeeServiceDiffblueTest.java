package com.jpa.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jpa.entities.Department;
import com.jpa.entities.Employee;
import com.jpa.repository.DepartmentRepository;
import com.jpa.repository.EmployeeRepository;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ContextConfiguration(classes = {EmployeeService.class})
//@ExtendWith(SpringExtension.class)
class EmployeeServiceDiffblueTest {
    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private EmployeeRepository employeeRepository;

   // @Autowired
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    /**
     * Method under test: {@link EmployeeService#saveEmployee(Employee)}
     */
    @Test
    void testSaveEmployee() {


        // Arrange
        Department department = new Department();
        department.setDepartmentName("Department Name");
        department.setEmployees(new ArrayList<>());
        department.setId(1L);

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setId(1L);
        employee.setName("Name");
        employee.setSalary(1L);
        when(employeeRepository.save(Mockito.<Employee>any())).thenReturn(employee);

        Department department2 = new Department();
        department2.setDepartmentName("Department Name");
        department2.setEmployees(new ArrayList<>());
        department2.setId(1L);

        Employee employee2 = new Employee();
        employee2.setDepartment(department2);
        employee2.setId(1L);
        employee2.setName("Name");
        employee2.setSalary(1L);

        // Act
        Employee actualSaveEmployeeResult = employeeService.saveEmployee(employee);

        // Assert
        verify(employeeRepository).save(isA(Employee.class));
        assertSame(employee, actualSaveEmployeeResult);

    }
}
