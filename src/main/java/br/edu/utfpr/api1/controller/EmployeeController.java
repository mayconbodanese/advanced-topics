package br.edu.utfpr.api1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.utfpr.api1.model.Employee;
import br.edu.utfpr.api1.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/employee", produces = "application/json")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/:id")
    public Employee getOne(
            @RequestParam(value = "id", required = false) Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/")
    public Employee create(@RequestBody Employee p) {
        return employeeService.createEmployee(p);
    }
}