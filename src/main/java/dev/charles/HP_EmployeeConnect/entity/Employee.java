package dev.charles.HP_EmployeeConnect.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {

    @Id
    private String employeeID; // Preset String ID, no auto-generation

    private String firstName;
    private String lastName;
    private String email;
    private String title;

    // Parameterized constructor to accept a specific employee ID
    public Employee(String employeeID, String firstName, String lastName, String email, String title) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    // Default constructor for JPA
    public Employee() {

    }
}
