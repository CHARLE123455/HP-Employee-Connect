package dev.charles.HP_EmployeeConnect.controller;

import dev.charles.HP_EmployeeConnect.entity.Employee;
import dev.charles.HP_EmployeeConnect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public List<Employee> gettAllEmployees(){
        return employeeRepository.findAll();
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
