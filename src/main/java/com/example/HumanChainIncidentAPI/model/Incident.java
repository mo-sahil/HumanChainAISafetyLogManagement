package com.example.HumanChainIncidentAPI.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "incidents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {
    @Id
    private String id;

    private String title;
    private String description;
    private String severity; // "Low", "Medium", "High"
    private Instant reportedAt;
}
