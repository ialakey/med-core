package com.alakey.fhirproject.service;

import com.alakey.fhirproject.model.PatientModel;
import com.alakey.fhirproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientModel savePatient(PatientModel patient) {
        return patientRepository.save(patient);
    }

    @Override
    public PatientModel getPatientById(String id) {
        Optional<PatientModel> patient = patientRepository.findById(id);
        return patient.orElseThrow(() -> new RuntimeException("Patient not found with ID: " + id));
    }

    @Override
    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void deletePatient(String id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new RuntimeException("Patient not found with ID: " + id);
        }
    }
}
