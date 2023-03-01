package peaksoft.service;

import org.springframework.stereotype.Service;
import peaksoft.entities.Hospital;

import java.util.List;


public interface HospitalService {
    void save(Hospital hospital);
    List<Hospital> getAllHospital();

    Hospital getHospitalById(Long id);
    void deleteHospitalById(Long id);

    void updateHospital(Long id, Hospital updateHospital);

}
