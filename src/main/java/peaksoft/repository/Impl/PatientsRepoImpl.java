//package peaksoft.repository.Impl;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//import peaksoft.entities.Patient;
//import peaksoft.repository.PatientsRepository;
//
//import java.util.List;
//
//@Repository
//@Transactional
//public class PatientsRepoImpl implements PatientsRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public void save(Patient patient) {
//        entityManager.persist(patient);
//
//    }
//
//    @Override
//    public List<Patient> getAllPatient() {
//        return entityManager.createQuery("select p from Patient p", Patient.class).getResultList();
//    }
//
//    @Override
//    public Patient getPatientById(Long id) {
//        return entityManager.find(Patient.class,id);
//    }
//
//    @Override
//    public void deletePatientById(Long id) {
//        Patient patient = entityManager.find(Patient.class, id);
//        entityManager.remove(patient);
//    }
//
//    @Override
//    public void updatePatient(Long id, Patient updatePatient) {
//
//    }
//}
