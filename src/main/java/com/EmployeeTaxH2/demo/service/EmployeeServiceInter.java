package com.EmployeeTaxH2.demo.service;

import java.util.List;


import com.EmployeeTaxH2.demo.entity.Employee;
import com.EmployeeTaxH2.demo.entity.TaxDetails;

public interface EmployeeServiceInter {

	Employee addEmployee(Employee emp);

	Employee fetchEmployeeById(Long id);

	TaxDetails calculateTax(Employee empTaxDetails);

	List<Employee> getAllEmployee();

}
