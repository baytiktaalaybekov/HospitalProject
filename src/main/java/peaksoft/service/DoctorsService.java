package peaksoft.service;

import peaksoft.entities.Appointment;
import peaksoft.entities.Doctor;

import java.util.List;

public interface DoctorsService {
    void saveDoctor(Doctor doctor);
    List<Doctor> getAllDoctor();

    Doctor getDoctorById(Long id);
    void deleteDoctorById(Long id);

    void updateDoctor(Long id,Doctor updateDoctor);

}
