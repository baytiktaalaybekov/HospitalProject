package peaksoft.service.Impl;

import org.springframework.stereotype.Service;
import peaksoft.entities.Hospital;
import peaksoft.repository.HospitalRepository;
import peaksoft.service.HospitalService;

import java.util.List;
@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }


    @Override
    public void save(Hospital hospital) {
        hospitalRepository.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalRepository.getAllHospital();
    }

    @Override
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.getHospitalById(id);
    }

    @Override
    public void deleteHospitalById(Long id) {
        hospitalRepository.deleteHospitalById(id);
    }

    @Override
    public void updateHospital(Long id, Hospital updateHospital) {
        hospitalRepository.updateHospital(id,updateHospital);
    }

}
