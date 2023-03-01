package peaksoft.repository;

import org.springframework.stereotype.Repository;
import peaksoft.entities.Appointment;
import peaksoft.entities.Hospital;

import java.util.List;

@Repository
public interface HospitalRepository {
    void save(Hospital hospital);
    List<Hospital> getAllHospital();

    Hospital getHospitalById(Long id);
    void deleteHospitalById(Long id);

    void updateHospital(Long id,Hospital updateHospital);

    void merge(Hospital hospital, Appointment appointment1);

}
