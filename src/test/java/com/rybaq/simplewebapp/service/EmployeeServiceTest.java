package com.rybaq.simplewebapp.service;

import com.rybaq.simplewebapp.dao.EmployeeDao;
import com.rybaq.simplewebapp.dto.Employee;
import com.rybaq.simplewebapp.dto.Gender;
import com.rybaq.simplewebapp.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

    private final Employee employee = new Employee();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        employee.setJobTitle("java developer");
        employee.setLastName("Rybak");
        employee.setFirstName("Alexander");
        employee.setGender(Gender.MALE);
        employee.setDateOfBirth(new Date());
    }

    @Test
    void getAllEmployees() throws ResourceNotFoundException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee);

        when(employeeDao.getAllEmployees()).thenReturn(employeeList);
        List<Employee> allEmployees = employeeService.getAllEmployees();

        assertEquals(allEmployees, employeeList);
    }

    @Test
    void getEmployeeById() throws ResourceNotFoundException {
        when(employeeDao.getEmployeeById(anyLong())).thenReturn(employee);
        Employee employeeById = employeeService.getEmployeeById(anyLong());
        assertEquals(employeeById, employee);
    }
}