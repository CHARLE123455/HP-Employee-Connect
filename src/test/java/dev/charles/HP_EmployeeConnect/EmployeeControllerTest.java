package dev.charles.HP_EmployeeConnect;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.charles.HP_EmployeeConnect.controller.EmployeeController;
import dev.charles.HP_EmployeeConnect.entity.Employee;
import dev.charles.HP_EmployeeConnect.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void addEmployee_shouldReturnCreatedEmployee() throws Exception {
        // Arrange: Define an Employee to save and expected output
        Employee employee = new Employee("HP1101087", "Charles", "Owuala", "owualacharles@outlook.com", "Software Engineer");

        Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);

        // Act and Assert
        mockMvc.perform(post("/api/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.employeeID").value("HP1101087"))
                .andExpect(jsonPath("$.firstName").value("Charles"))
                .andExpect(jsonPath("$.lastName").value("Owuala"))
                .andExpect(jsonPath("$.email").value("owualacharles@outlook.com"))
                .andExpect(jsonPath("$.title").value("Software Engineer"));
    }

    @Test
    void addEmployee_shouldReturnBadRequestForInvalidInput() throws Exception {
        // Act and Assert: Send an invalid request (e.g., missing required fields)
        Employee invalidEmployee = new Employee();  // Empty employee

        mockMvc.perform(post("/api/employees/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidEmployee)))
                .andExpect(status().isBadRequest());
    }
}
