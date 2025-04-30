package br.edu.utfpr.api1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.utfpr.api1.dto.EmployeeDto;
import br.edu.utfpr.api1.model.Employee;
import br.edu.utfpr.api1.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>>  getAll() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping()
    public Employee create(@RequestBody EmployeeDto p) {
        return employeeService.createEmployee(p);
    }
}