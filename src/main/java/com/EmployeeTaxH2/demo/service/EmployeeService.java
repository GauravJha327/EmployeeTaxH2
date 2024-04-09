package com.EmployeeTaxH2.demo.service;

import java.util.Calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeTaxH2.demo.entity.Employee;
import com.EmployeeTaxH2.demo.entity.TaxDetails;
import com.EmployeeTaxH2.demo.repository.EmployeeDAO;

@Service
public class EmployeeService implements EmployeeServiceInter{
	
	@Autowired
	private EmployeeDAO empDao;

	@Override
	public Employee addEmployee(Employee emp) {
		Employee empDto = empDao.save(emp);
		return empDto;
	}
	
	
	public TaxDetails calculateTax(Employee employee) {
        Calendar doj = Calendar.getInstance();
        doj.setTime(employee.getDoj());
        int joiningMonth = doj.get(Calendar.MONTH) + 1; // Calendar.MONTH is 0-based
        int monthsWorked = 12 - joiningMonth + 1;

        double yearlySalary = employee.getSalary() * monthsWorked;
        double taxAmount = 0;
        double cessAmount = 0;

        if (yearlySalary > 250000) {
            if (yearlySalary <= 500000) {
                taxAmount += (yearlySalary - 250000) * 0.05;
            } else {
                taxAmount += 250000 * 0.05;
                if (yearlySalary <= 1000000) {
                    taxAmount += (yearlySalary - 500000) * 0.10;
                } else {
                    taxAmount += 500000 * 0.10;
                    taxAmount += (yearlySalary - 1000000) * 0.20;
                }
            }
        }

        // Additional cess of 2% on amount more than 2500000
        if (yearlySalary > 2500000) {
            cessAmount = (yearlySalary - 2500000) * 0.02;
        }

        return new TaxDetails(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary, taxAmount, cessAmount);
    }


	@Override
	public Employee fetchEmployeeById(Long id) {
		Employee details=empDao.findById(id).get();
		return details;
	}


	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empAllDetails = empDao.findAll();
		return empAllDetails;
	}

}
