package dev.charles.HP_EmployeeConnect.repository;

import dev.charles.HP_EmployeeConnect.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
