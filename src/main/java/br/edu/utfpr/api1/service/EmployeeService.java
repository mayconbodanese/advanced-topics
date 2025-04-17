package br.edu.utfpr.api1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.api1.dto.EmployeeDto;
import br.edu.utfpr.api1.model.Employee;
import br.edu.utfpr.api1.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, EmployeeDto dto) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (dto.getName() != null) {
            employee.setName(dto.getName());
        }
        if (dto.getEmail() != null) {
            employee.setEmail(dto.getEmail());
        }

        return employeeRepository.save(employee);
    }
}