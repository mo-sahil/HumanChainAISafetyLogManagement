package com.example.HumanChainIncidentAPI;

import com.example.HumanChainIncidentAPI.model.Incident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncidentRepository extends MongoRepository<Incident, String> {
}
