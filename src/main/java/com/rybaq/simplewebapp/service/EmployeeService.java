package com.rybaq.simplewebapp.service;

import com.rybaq.simplewebapp.dao.EmployeeDao;
import com.rybaq.simplewebapp.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeDao employeeDao;

    public Optional<List<Employee>> getAllEmployees(){
        return Optional.of(employeeDao.getAllEmployees());
    }

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeDao.deleteEmployeeById(id);
    }

    public Optional<Employee> getEmployeeById(Long id){
        return Optional.of(employeeDao.getEmployeeById(id));
    }

    public void updateEmployee(Employee em){
        employeeDao.updateEmployee(em);
    }
}
