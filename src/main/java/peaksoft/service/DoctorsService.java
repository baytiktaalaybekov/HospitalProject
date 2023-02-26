package peaksoft.service;

import peaksoft.entities.Appointment;
import peaksoft.entities.Doctor;

import java.util.List;

public interface DoctorsService {

    String saveDoctor(Long hospitalId,Doctor doctor);

    List<Doctor>getAllDoctor(Long id);
    Doctor getByDoctorId(Long id);

    void deleteDoctorById(Long id);

    void assignDoctor(Long doctorId, Doctor doctor);

    void update(Long doctorId, Doctor doctor);
}
