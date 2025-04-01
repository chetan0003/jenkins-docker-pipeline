package com.jpa.service;

import com.jpa.entities.Employee;
import com.jpa.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//@SpringBootTest
public class EmployeeServiceTests {



    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void SetUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void test() {
        //assertEquals(5, 2+2);
        Employee returnEmp = Employee.builder().id(1L).name("CHETAN").salary(50000L).build();
        when(employeeRepository.save(returnEmp)).thenReturn(returnEmp);
        Employee employee = employeeService.saveEmployee(returnEmp);
        assertNotNull(employee);

    }


    //@Test

    @ParameterizedTest
    @CsvSource(
            {
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23",
                    "24",
                    "25",
                    "26",
                    "27",
                    "28",
                    "29",
                    "30",
                    "31",
                    "32",
                    "33",
                    "34",
                    "500"
            }
    )
    void testWithParamO(long id) {
        assertNotNull(employeeRepository.findById(id), "Employee with id " + id + " not found");

    }
}
