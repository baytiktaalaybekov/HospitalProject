package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Hospital;
import peaksoft.repository.HospitalRepository;

import java.util.List;
@Repository
@Transactional
public class HospitalRepoImpl implements HospitalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return entityManager.createQuery("select h from Hospital h",Hospital.class).getResultList();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return entityManager.find(Hospital.class,id);
    }

    @Override
    public void deleteHospitalById(Long id) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        entityManager.remove(hospital);
    }

    @Override
    public void updateHospital(Long id, Hospital updateHospital) {
        Hospital hospital = entityManager.find(Hospital.class, id);
        hospital.setName(updateHospital.getName());
        hospital.setAddress(updateHospital.getAddress());
        hospital.setImage(updateHospital.getImage());
    }
}
