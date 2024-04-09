package com.EmployeeTaxH2.demo.entity;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="EMPLOYEE")
@Getter
@Setter
@ToString
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

    @Column(unique = true)
    private String employeeId;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    
    @ElementCollection
    private List<String> phoneNumbers;

    private Date doj;
    private Double salary; // Monthly salary

}
