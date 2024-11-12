package dev.charles.HP_EmployeeConnect.entity;

import dev.charles.HP_EmployeeConnect.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class EmployeeManager {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        Employee employee1 = new Employee("HP1101087","Charles", "Owuala", "owualacharles@outlook.com", "Software Engineer");
        Employee employee2 = new Employee("HP1101035","Zainab", "Babalola", "zainmoor@gmail.com", "Product Manager");
        Employee employee3 = new Employee("HP1101076","David", "Dinneya", "divad98@yahoo.com", "Cloud Architect");

        employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));
    }
}
