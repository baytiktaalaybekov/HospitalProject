package peaksoft.service.Impl;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.entities.Hospital;
import peaksoft.repository.DepartmentRepository;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.DepartmentService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public void saveDepartment(Long id,Department department) {
        departmentRepository.saveDepartment(id, department);
    }

    @Override
    public List<Department> getAllDepartment(Long id) {
    return departmentRepository.getAllDepartment(id);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteDepartmentById(id);
    }

    @Override
    public void updateDepartment(Long id, Department updateDepartment) {
        departmentRepository.updateDepartment(id,updateDepartment);
    }
}
