package com.example.HumanChainIncidentAPI.dto;

import lombok.Data;

@Data
public class IncidentRequest {
    private String title;
    private String description;
    private String severity;
}
