package com.alakey.fhirproject.controller;

import com.alakey.fhirproject.model.PatientModel;
import com.alakey.fhirproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientModel> createPatient(@RequestBody PatientModel patient) {
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientModel> getPatient(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }
}