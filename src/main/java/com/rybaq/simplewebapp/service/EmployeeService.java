package com.rybaq.simplewebapp.service;

import com.rybaq.simplewebapp.dao.EmployeeDao;
import com.rybaq.simplewebapp.dto.Employee;
import com.rybaq.simplewebapp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public List<Employee> getAllEmployees() throws ResourceNotFoundException {
        if (employeeDao.getAllEmployees().isEmpty()) {
            throw new ResourceNotFoundException("there are no employees");
        }
        return employeeDao.getAllEmployees();
    }

    public void addEmployee(Employee employee) throws ResourceNotFoundException {
        if (employee == null) {
            throw new ResourceNotFoundException("there are no employee to save to db");
        }
        employeeDao.addEmployee(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeDao.deleteEmployeeById(id);
    }

    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        if (employeeDao.getEmployeeById(id) == null) {
            throw new ResourceNotFoundException("there are no such employee");
        }
        return employeeDao.getEmployeeById(id);
    }

    public void updateEmployee(Long id, Employee em) throws ResourceNotFoundException {
        Employee employeeById = employeeDao.getEmployeeById(id);
        if (employeeById == null) {
            throw new ResourceNotFoundException("there are no such employee to update");
        }
        employeeById.setFirstName(em.getFirstName());
        employeeById.setLastName(em.getLastName());
        employeeById.setJobTitle(em.getJobTitle());
        employeeById.setDateOfBirth(em.getDateOfBirth());
        employeeById.setGender(em.getGender());
        employeeDao.updateEmployee(employeeById);
    }
}
