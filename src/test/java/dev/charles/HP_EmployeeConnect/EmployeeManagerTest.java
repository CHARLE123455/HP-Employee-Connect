package dev.charles.HP_EmployeeConnect;

import dev.charles.HP_EmployeeConnect.entity.Employee;
import dev.charles.HP_EmployeeConnect.entity.EmployeeManager;
import dev.charles.HP_EmployeeConnect.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeManager employeeManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init_shouldSaveAllEmployees() {
        // Arrange
        Employee employee1 = new Employee("HP1101087", "Charles", "Owuala", "owualacharles@outlook.com", "Software Engineer");
        Employee employee2 = new Employee("HP1101035", "Zainab", "Babalola", "zainmoor@gmail.com", "Product Manager");
        Employee employee3 = new Employee("HP1101076", "David", "Dinneya", "divad98@yahoo.com", "Cloud Architect");

        List<Employee> expectedEmployees = List.of(employee1, employee2, employee3);

        // Act
        employeeManager.init();

        // Assert
        verify(employeeRepository, times(1)).saveAll(expectedEmployees);
    }

    @Test
    void init_shouldNotSaveEmployeesIfEmpty() {
        // Arrange: Set up an empty list
        List<Employee> emptyEmployeeList = Collections.emptyList();

        // Act
        employeeManager.init();

        // Assert: Verify saveAll was not called since the list was empty
        verify(employeeRepository, never()).saveAll(emptyEmployeeList);
    }
}
