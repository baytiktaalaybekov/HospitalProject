package peaksoft.service.Impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.entities.Doctor;
import peaksoft.repository.DepartmentRepository;
import peaksoft.repository.DoctorsRepository;
import peaksoft.service.DoctorsService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoctorsServiceImpl implements DoctorsService {
    private final DoctorsRepository doctorsRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public String saveDoctor(Long hospitalId, Doctor doctor) {
        return doctorsRepository.saveDoctor(hospitalId,doctor);
    }

    @Override
    public List<Doctor> getAllDoctor(Long id) {
        return doctorsRepository.getAllDoctor(id);
    }

    @Override
    public Doctor getByDoctorId(Long id) {
        return doctorsRepository.getByDoctorId(id);
    }



    @Override
    public void deleteDoctorById(Long id) {
        doctorsRepository.deleteDoctorById(id);
    }

    @Override
    public void assignDoctor(Long doctorId, Doctor doctor) {
        Department department = departmentRepository.getDepartmentById(doctor.getDepartmentId());
        Doctor oldDoctor = doctorsRepository.getByDoctorId(doctorId);
        department.addDoctor(oldDoctor);
        oldDoctor.addDepartment(department);
        doctorsRepository.assignDoctor(doctor);
    }

    @Override
    public void update(Long doctorId, Doctor doctor) {
        doctorsRepository.updateDoctor(doctorId,doctor);
    }
}
