package com.ChristopherIngham.Spring_Boot_PostgreSQL;

import com.ChristopherIngham.Spring_Boot_PostgreSQL.Employee;
import com.ChristopherIngham.Spring_Boot_PostgreSQL.EmployeeRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


// service layer, business logic
@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    // creating link to EmployeeRepo
    private final EmployeeRepo employeeRepo;

    /*
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    */

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Integer id){
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        log.info("Employee with id: {} doesn't exist", id);
        return null;
    }

    public Employee saveEmployee(Employee employee){
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        Employee savedEmployee = employeeRepo.save(employee);

        log.info("Employee with: {} saved successfully", employee.getId());
        return savedEmployee;
    }

    public Employee updateEmployee(Employee employee){
        Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());
        employee.setCreatedAt(existingEmployee.get().getCreatedAt());
        employee.setUpdatedAt(LocalDateTime.now());

        Employee updateEmployee = employeeRepo.save(employee);

        log.info("Employee with id: {} updated successfully", employee.getId());
        return updateEmployee;
    }

    public void deleteEmployeeById(Integer id){
        employeeRepo.deleteById(id);
    }
}
