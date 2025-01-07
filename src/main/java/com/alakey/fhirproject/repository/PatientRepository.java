package com.alakey.fhirproject.repository;

import com.alakey.fhirproject.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, String> {
}
