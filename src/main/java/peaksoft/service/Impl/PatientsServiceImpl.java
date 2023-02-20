//package peaksoft.service.Impl;
//
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import peaksoft.entities.Patient;
//import peaksoft.repository.PatientsRepository;
//import peaksoft.service.PatientsService;
//
//import java.util.List;
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class PatientsServiceImpl implements PatientsService {
//    private final PatientsRepository patientsRepository;
//    @Override
//    public void save(Patient patient) {
//        patientsRepository.save(patient);
//    }
//
//    @Override
//    public List<Patient> getAllPatient() {
//        return patientsRepository.getAllPatient();
//    }
//
//    @Override
//    public Patient getPatientById(Long id) {
//        return patientsRepository.getPatientById(id);
//    }
//
//    @Override
//    public void deletePatientById(Long id) {
//        patientsRepository.deletePatientById(id);
//    }
//
//    @Override
//    public void updatePatient(Long id, Patient updatePatient) {
//
//    }
//}
