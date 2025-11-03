package com.ChristopherIngham.Spring_Boot_PostgreSQL;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// used for mapping
// request are handled
@RestController
@RequestMapping("/employee/v1")
@RequiredArgsConstructor
@Validated
public class EmployeeController {

    private final EmployeeService employeeService;

    /*
    Get request localhost:8080/employee/v1/
    Fetches all employees from the employee table
    @return List of employees
     */
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());

    }

    /*
    Get request localhost:8080/employee/v1/1
    fetches employee with given id
    @param employee id
    @return employee with given id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeeService.getEmployeeById(id));
    }

    /*
    Post request localhost:8080/employee/v1/
    Save employee entity
    @param employee body
    @return saved employee entity
     */
    @PostMapping("/")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
         return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
    }

    /*
    Put request localhost:8080/employee/v1/
    update employee entity
    @param employee entity updated
    @return update employee
     */
    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.updateEmployee(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok().body("Deleted employee successfully");
    }

}
