package br.edu.utfpr.api1.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private String name;
    private String email;
    private Long propertyId;
}
