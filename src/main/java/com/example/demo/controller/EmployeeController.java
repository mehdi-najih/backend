package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController  {

    //lien enter data base et spring boot
    @Autowired
    private EmployeeService employeeService;

private EmployeeRepository employeeRepository ;

   //Filtring
    /*
    @GetMapping("/employees")
    public Page<Employee> getAllEmployeeFiltring(@RequestParam (required = false) String firstName ,
                                                 @RequestParam (required = false) String lastName,
                                                 @RequestParam (required = false) String emailId ,
                                                 @RequestParam  (required = false) Integer pageNo ,
                                                 @RequestParam (required = false) Integer recordCount){
        return  employeeService.getAllEmployeeFiltring(firstName , lastName , emailId , pageNo ,recordCount);
    }
*/

    @GetMapping("/employees")
    public Page<Employee> getAllEmployeeFiltring(@RequestParam Map<String, String> filters){
        return  employeeService.getAllEmployeeFiltring(filters);
    };
// insert
    @PostMapping("/employee")
    public Employee saveEmployeeDetails(@RequestBody Employee employee){
        return employeeService.saveEmployeeDetails(employee);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }


    // update
    @PutMapping("/employee")
    public  Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }
    // Delete
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


}
