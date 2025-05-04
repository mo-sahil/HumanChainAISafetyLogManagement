package com.example.HumanChainIncidentAPI.controller;

import com.example.HumanChainIncidentAPI.dto.IncidentRequest;
import com.example.HumanChainIncidentAPI.model.Incident;
import com.example.HumanChainIncidentAPI.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody IncidentRequest request) {
        return ResponseEntity.status(201).body(incidentService.createIncident(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable String id) {
        return ResponseEntity.ok(incidentService.getIncidentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable String id) {
        incidentService.deleteIncident(id);
        return ResponseEntity.noContent().build();
    }
}
