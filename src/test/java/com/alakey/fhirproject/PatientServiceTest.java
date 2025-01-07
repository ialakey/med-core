package com.alakey.fhirproject;

import com.alakey.fhirproject.model.PatientModel;
import com.alakey.fhirproject.repository.PatientRepository;
import com.alakey.fhirproject.service.PatientService;
import com.alakey.fhirproject.service.PatientServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PatientServiceTest {

    @Test
    void testGetPatientById() {
        PatientRepository mockRepository = Mockito.mock(PatientRepository.class);
        PatientService patientService = new PatientServiceImpl(mockRepository);
        PatientModel mockPatient = new PatientModel();
        mockPatient.setId("1");
        PatientModel.Name name = new PatientModel.Name();
        name.setFamily("John Doe");
        mockPatient.setName(name);
        Mockito.when(mockRepository.findById("1")).thenReturn(Optional.of(mockPatient));
        PatientModel result = patientService.getPatientById("1");

        assertEquals("John Doe", result.getName().getFamily());
    }
}