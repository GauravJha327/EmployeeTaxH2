package com.EmployeeTaxH2.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;



import com.EmployeeTaxH2.demo.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long>{

}
