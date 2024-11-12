package dev.charles.HP_EmployeeConnect.entity;

import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    private Employees(List<Employee> employeeList){
        this.employeeList=employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
