package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.entities.Hospital;
import peaksoft.repository.DepartmentRepository;

import java.util.List;
@Service
@Transactional
public class DepartmentRepoImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveDepartment(Long id, Department department) {
        Hospital hospital = entityManager.find(Hospital.class,id);
        hospital.addDepartment(department);
        department.setHospital(hospital);
        entityManager.merge(department);

    }

    @Override
    public List<Department> getAllDepartment(Long id) {
        return entityManager
                .createQuery("select d from Department d join d.hospital h where h.id = :id", Department.class)
                .setParameter("id", id)
        .getResultList();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return entityManager.find(Department.class,id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Department department = entityManager.find(Department.class, id);
        entityManager.remove(department);
    }

    @Override
    public void updateDepartment(Long id, Department updateDepartment) {
        Department department = entityManager.find(Department.class, id);
        department.setName(updateDepartment.getName());
        entityManager.merge(department);
    }

}
