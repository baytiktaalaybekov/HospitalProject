package peaksoft.service;

import peaksoft.entities.Department;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Long id,Department department);
    List<Department> getAllDepartment(Long id);

    Department getDepartmentById(Long id);
    void deleteDepartmentById(Long id);

    void updateDepartment(Long id,Department updateDepartment);



}
