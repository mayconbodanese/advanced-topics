package br.edu.utfpr.api1.dto;

import java.util.List;
import lombok.Data;

@Data
public class PropertyDto {
    private String name;
    private List<Long> orchardIds;  
    private List<Long> employeeIds;
}