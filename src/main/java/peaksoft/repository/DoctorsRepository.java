package peaksoft.repository;

import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;

import java.util.List;

public interface DoctorsRepository {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();

    Doctor getDoctorById(Long id);
    void deleteDoctorById(Long id);

    void updateDoctor(Long id,Doctor updateDoctor);


}
