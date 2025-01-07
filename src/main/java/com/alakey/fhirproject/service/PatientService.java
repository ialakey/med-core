package com.alakey.fhirproject.service;

import com.alakey.fhirproject.model.PatientModel;

import java.util.List;

public interface PatientService {
    PatientModel savePatient(PatientModel patient);
    PatientModel getPatientById(String id);
    List<PatientModel> getAllPatients();
    void deletePatient(String id);
}
