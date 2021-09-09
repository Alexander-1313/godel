package com.rybaq.simplewebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private Gender gender;

    private Long departmentId;

    private Date dateOfBirth;
}
