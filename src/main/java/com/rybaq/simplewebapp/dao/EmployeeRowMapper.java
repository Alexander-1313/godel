package com.rybaq.simplewebapp.dao;

import com.rybaq.simplewebapp.dto.Employee;
import com.rybaq.simplewebapp.dto.Gender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        final Employee employee = new Employee();

        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        if(resultSet.getString("gender") != null) {
            employee.setGender(Gender.valueOf(resultSet.getString("gender").trim()));
        }
        employee.setDepartmentId(resultSet.getLong("department_id"));
        employee.setJobTitle(resultSet.getString("job_title"));
        try {
            if(resultSet.getString("dateOfBirth") != null) {
                employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString("dateOfBirth")));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
