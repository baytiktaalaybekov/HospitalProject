//package peaksoft.repository.Impl;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//import peaksoft.entities.Doctor;
//import peaksoft.repository.DoctorsRepository;
//
//import java.util.List;
//@Service
//@Transactional
//public class DoctorsRepoImpl implements DoctorsRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public void saveDoctor(Doctor doctor) {
//        entityManager.persist(doctor);
//
//    }
//
//    @Override
//    public List<Doctor> getAllDoctor() {
//        return entityManager.createQuery("select d from Doctor d",Doctor.class).getResultList();
//    }
//
//    @Override
//    public Doctor getDoctorById(Long id) {
//        return entityManager.find(Doctor.class,id);
//    }
//
//    @Override
//    public void deleteDoctorById(Long id) {
//        Doctor doctor = entityManager.find(Doctor.class, id);
//        entityManager.remove(doctor);
//    }
//
//    @Override
//    public void updateDoctor(Long id, Doctor updateDoctor) {
//
//    }
//}
