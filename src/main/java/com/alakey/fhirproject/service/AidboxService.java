package com.alakey.fhirproject.service;

import com.alakey.fhirproject.model.PatientModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AidboxService {

    private final RestTemplate restTemplate;

    public AidboxService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String savePatientToAidbox(PatientModel patient) {
        String aidboxUrl = "http://localhost:8080/aidbox/fhir/Patient";
        ResponseEntity<String> response = restTemplate.postForEntity(aidboxUrl, patient, String.class);
        return response.getBody();
    }
}
