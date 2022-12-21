package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.validation.CustomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
@Autowired
private  EmployeeRepository employeeRepository ;
@Autowired
    private CustomValidation customValidation;


//insert
    public Employee saveEmployeeDetails(Employee employee){
        if (!customValidation.checNamelength(employee.getFirstName() ,  employee.getLastName() , employee.getEmailId())){
            return null;
        }
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    //update
    public  Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //Delete
    public ResponseEntity<HttpStatus> deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


//Filtring
public Page<Employee> getAllEmployeeFiltring(String firstName , String lastName , String emailId , Integer pageNo , Integer recordCount){

   Pageable pageable =   PageRequest.of(pageNo !=  null ? pageNo :0 , recordCount != null ? recordCount : 5);
    return employeeRepository.getEmployees(firstName,lastName, emailId ,pageable);
}



}
