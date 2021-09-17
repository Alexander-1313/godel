package com.rybaq.simplewebapp.rest;

import com.rybaq.simplewebapp.dto.Employee;
import com.rybaq.simplewebapp.exception.ResourceNotFoundException;
import com.rybaq.simplewebapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() throws ResourceNotFoundException {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeeById(@RequestBody Employee employee) throws ResourceNotFoundException {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("employee was saved", HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("employee with id=" + id + " was removed", HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployeeById(@RequestBody Employee employee, @PathVariable Long id) throws ResourceNotFoundException {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>("employee with id = " + employee.getId() + " was updated", HttpStatus.OK);
    }
}
