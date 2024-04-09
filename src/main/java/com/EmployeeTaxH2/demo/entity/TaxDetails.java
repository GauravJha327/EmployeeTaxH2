package com.EmployeeTaxH2.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TaxDetails {
	
	 private String employeeCode;
	    private String firstName;
	    private String lastName;
	    private double yearlySalary;
	    private double taxAmount;
	    private double cessAmount;

	    
	    public TaxDetails(String employeeCode, String firstName, String lastName, double yearlySalary, double taxAmount, double cessAmount) {
	        this.employeeCode = employeeCode;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.yearlySalary = yearlySalary;
	        this.taxAmount = taxAmount;
	        this.cessAmount = cessAmount;
	    }

}
