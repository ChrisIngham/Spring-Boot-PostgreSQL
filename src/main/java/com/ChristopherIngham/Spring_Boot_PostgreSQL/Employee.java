package com.ChristopherIngham.Spring_Boot_PostgreSQL;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// generate default constructors containing all attributes
@NoArgsConstructor
@AllArgsConstructor
// generates getters, setters, toString()
@Data
// JPA uses existing table to store instances of this entity
@Entity
// allows for customization by specific table name, etc.
@Table(name = "employee")
public class Employee {

    // identifies primary key
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String destination;
    private String phoneNumber;
    private LocalDate joinedOn;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
