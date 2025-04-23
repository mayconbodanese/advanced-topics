package br.edu.utfpr.api1.dto;

import lombok.Data;

@Data
public class OrchardDto {
    private String latitude;
    private String longitude;
    private Long propertyId;
}
