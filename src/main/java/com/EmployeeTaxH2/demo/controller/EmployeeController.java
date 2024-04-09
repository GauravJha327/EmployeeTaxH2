package com.EmployeeTaxH2.demo.controller;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeTaxH2.demo.entity.Employee;
import com.EmployeeTaxH2.demo.entity.TaxDetails;
import com.EmployeeTaxH2.demo.service.EmployeeServiceInter;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceInter empSerIntr;
	
	
    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
        try {
            Employee empDetails = empSerIntr.addEmployee(emp);
            return new ResponseEntity<>(empDetails, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Employee data violates constraints", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
//	@PostMapping("/save")
//	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
//		Employee empDetails= empSerIntr.addEmployee(emp);
//		return new ResponseEntity<Employee>(empDetails,HttpStatus.CREATED); 
//	}
	
	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> empAllDetails= empSerIntr.getAllEmployee();
		return new ResponseEntity<List<Employee>>(empAllDetails,HttpStatus.OK);
	}
	
	
//	@GetMapping("/getDetails/{id}")
//	public ResponseEntity<TaxDetails> calculateTax(@PathVariable Long id){
//		Employee empTaxDetails= empSerIntr.fetchEmployeeById(id);
//		TaxDetails taxDetails=empSerIntr.calculateTax(empTaxDetails);
//		
//		return new ResponseEntity<TaxDetails>(taxDetails,HttpStatus.OK);
//	}
	
	@GetMapping("/getDetails/{id}")
    public ResponseEntity<?> getTaxDetails(@PathVariable Long id) {
        try {
            Employee employee = empSerIntr.fetchEmployeeById(id);
            TaxDetails taxDetails = empSerIntr.calculateTax(employee);
            return new ResponseEntity<>(taxDetails, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
