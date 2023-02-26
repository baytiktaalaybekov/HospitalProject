package peaksoft.repository;

import peaksoft.entities.Doctor;

import java.util.List;

public interface DoctorsRepository {

    String saveDoctor(Long hospitalId,Doctor doctor);

    List<Doctor>getAllDoctor(Long id);
    Doctor getByDoctorId(Long id);
    void  updateDoctor(Long id,Doctor newDoctor);
    void deleteDoctorById(Long id);

    void assignDoctor(Doctor doctor);



}
