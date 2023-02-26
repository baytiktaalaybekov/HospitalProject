package peaksoft.repository;

import peaksoft.entities.Patient;

import java.util.List;

public interface PatientsRepository {
    void save(Patient patient);
    List<Patient> getAllPatient(Long hospitalId);

    Patient getPatientById(Long id);
    void deletePatientById(Long id);

    void updatePatient(Long id,Patient updatePatient);


}
