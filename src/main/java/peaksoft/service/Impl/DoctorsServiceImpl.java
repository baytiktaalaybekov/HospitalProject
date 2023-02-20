//package peaksoft.service.Impl;
//
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import peaksoft.entities.Doctor;
//import peaksoft.repository.DoctorsRepository;
//import peaksoft.service.DoctorsService;
//
//import java.util.List;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class DoctorsServiceImpl implements DoctorsService {
//    private final DoctorsRepository doctorsRepository;
//
//    @Override
//    public void saveDoctor(Doctor doctor) {
//        doctorsRepository.saveDoctor(doctor);
//
//    }
//
//    @Override
//    public List<Doctor> getAllDoctor() {
//        return doctorsRepository.getAllDoctor();
//    }
//
//    @Override
//    public Doctor getDoctorById(Long id) {
//        return doctorsRepository.getDoctorById(id);
//    }
//
//    @Override
//    public void deleteDoctorById(Long id) {
//        doctorsRepository.deleteDoctorById(id);
//    }
//
//    @Override
//    public void updateDoctor(Long id, Doctor updateDoctor) {
//
//    }
//}
