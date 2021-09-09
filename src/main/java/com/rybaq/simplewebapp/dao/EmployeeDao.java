package com.rybaq.simplewebapp.dao;

import com.rybaq.simplewebapp.dto.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeRowMapper());
    }

    public void addEmployee(Employee e){
        String sql = "insert into employee (first_name, last_name, job_title, department_id, gender, dateOfBirth) values(";
        jdbcTemplate.update(sql + "\'" + e.getFirstName() + "\' , "
                        + "\'" + e.getLastName() + "\' , "
                + "\'" + e.getJobTitle() + "\' , "
                + "\'" + e.getDepartmentId() + "\' , "
                + "\'" + e.getGender() + "\' , "
                + "\'" + e.getDateOfBirth() + "\'"
                + ")");
    }

    public void deleteEmployeeById(Long id){
        String sql = "delete from employee where id=?";
        jdbcTemplate.update(sql, id);
    }

    public Employee getEmployeeById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?", new EmployeeRowMapper(), id);
    }

    public void updateEmployee(Employee em){
        String sql = "update employee set first_name=?, last_name=?, department_id=?, job_title=?, gender=?, dateOfBirth=? where id=?";
        jdbcTemplate.update(sql, em.getFirstName(), em.getLastName(), em.getDepartmentId(), em.getJobTitle(),
                em.getGender().type(), em.getDateOfBirth(), em.getId());
    }
}
