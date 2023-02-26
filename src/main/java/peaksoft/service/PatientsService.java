package peaksoft.service;

import peaksoft.entities.Hospital;
import peaksoft.entities.Patient;

import java.util.List;

public interface PatientsService {
    void save(Long hospitalId,Patient patient);
    List<Patient> getAllPatient(Long hospitalId);

    Patient getPatientById(Long id);
    void deletePatientById(Long id);

    void updatePatient(Long id,Patient updatePatient);
}
