package com.example.HumanChainIncidentAPI.service;

import com.example.HumanChainIncidentAPI.dto.IncidentRequest;
import com.example.HumanChainIncidentAPI.exception.IncidentNotFoundException;
import com.example.HumanChainIncidentAPI.model.Incident;
import com.example.HumanChainIncidentAPI.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    public Incident createIncident(IncidentRequest request) {
        if (!List.of("Low", "Medium", "High").contains(request.getSeverity())) {
            throw new IllegalArgumentException("Invalid severity value");
        }

        Incident incident = Incident.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .severity(request.getSeverity())
                .reportedAt(Instant.now())
                .build();

        return incidentRepository.save(incident);
    }

    public Incident getIncidentById(String id) {
        return incidentRepository.findById(id)
                .orElseThrow(() -> new IncidentNotFoundException("Incident not found with id: " + id));
    }

    public void deleteIncident(String id) {
        if (!incidentRepository.existsById(id)) {
            throw new IncidentNotFoundException("Cannot delete. Incident not found with id: " + id);
        }
        incidentRepository.deleteById(id);
    }
}
