package peaksoft.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Hospital;
import peaksoft.entities.Patient;
import peaksoft.repository.HospitalRepository;
import peaksoft.repository.PatientsRepository;
import peaksoft.service.PatientsService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class PatientsServiceImpl implements PatientsService {
    private final PatientsRepository patientsRepository;
    private final HospitalRepository hospitalRepository;
    @Override
    public void save(Long hospitalId,Patient patient) {
        Hospital hospital = hospitalRepository.getHospitalById(hospitalId);
        hospital.setPatients(patient);
        patient.setHospital(hospital);
        patientsRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatient(Long hospitalId) {
        return patientsRepository.getAllPatient(hospitalId);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientsRepository.getPatientById(id);
    }

    @Override
    public void deletePatientById(Long id) {
        patientsRepository.deletePatientById(id);
    }

    @Override
    public void updatePatient(Long id, Patient updatePatient) {
        patientsRepository.updatePatient(id,updatePatient);

    }
}
