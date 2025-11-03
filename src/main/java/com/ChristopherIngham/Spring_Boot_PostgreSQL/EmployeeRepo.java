package com.ChristopherIngham.Spring_Boot_PostgreSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ChristopherIngham.Spring_Boot_PostgreSQL.Employee;


// JPA repo, CRUD operations (Create, Read, Update, Delete)
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
