package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.entities.Doctor;
import peaksoft.entities.Hospital;
import peaksoft.repository.DoctorsRepository;

import java.util.List;
@Service
@Transactional
public class DoctorsRepoImpl implements DoctorsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String saveDoctor(Long hospitalId, Doctor doctor) {
         entityManager.persist(doctor);
        Hospital hospital = entityManager.find(Hospital.class, hospitalId);
        doctor.setHospital(hospital);
        return "Successfully saved!";

    }

     @Override
    public List<Doctor> getAllDoctor(Long id) {
        return entityManager.createQuery("from Doctor d join d.hospital h where h.id =  :id", Doctor.class)
                .setParameter("id",id)
                .getResultList();
    }

    @Override
    public Doctor getByDoctorId(Long id) {
        return entityManager.find(Doctor.class,id);
    }

    @Override
    public void updateDoctor(Long id, Doctor newDoctor) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        doctor.setFirstName(newDoctor.getFirstName());
        doctor.setLastName(newDoctor.getLastName());
        doctor.setPosition(newDoctor.getPosition());
        doctor.setEmail(newDoctor.getEmail());
        entityManager.merge(doctor);
    }

    @Override
    public void deleteDoctorById(Long id) {
        Doctor doctor = entityManager.find(Doctor.class, id);
        entityManager.remove(doctor);
    }

    @Override
    public void assignDoctor(Doctor doctor) {
//        Department department = entityManager.find(Department.class,departmentId);
//        Doctor doctor = entityManager.find(Doctor.class, doctorId);
//        doctor.addDepartment(department);
//        department.addDoctor(doctor);
//        entityManager.merge(department);
//        entityManager.merge(doctor);
        entityManager.merge(doctor);
    }


}
