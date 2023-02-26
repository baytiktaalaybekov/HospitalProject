package peaksoft.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Appointment;
import peaksoft.entities.Hospital;
import peaksoft.repository.*;
import peaksoft.service.AppointmentsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;
    private final DepartmentRepository departmentRepository;
    private final DoctorsRepository doctorsRepository;
    private final HospitalRepository hospitalRepository;
    private final PatientsRepository patientsRepository;


    @Override
    public Appointment saveAppointment( Long id,Appointment appointment) {
        Hospital hospital = hospitalRepository.getHospitalById(id);
        Appointment appointment1 = new Appointment();
        appointment1.setDate(appointment.getDate());
        appointment1.setId(appointment.getId());

        appointment1.setDoctor(doctorsRepository.getByDoctorId(appointment.getDoctorId()));
        appointment1.setDepartment(departmentRepository.getDepartmentById(appointment.getDepartmentId()));
        appointment1.setPatient(patientsRepository.getPatientById(appointment.getPatientId()));
        hospital.addAppointment(appointment1);
        return appointmentsRepository.saveAppointment(appointment1);
    }

    @Override
    public List<Appointment> getAllAppointment(Long id) {
      return  appointmentsRepository.getAllAppointment(id);

    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentsRepository.getAppointmentById(id);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentsRepository.deleteAppointmentById(id);
    }

    @Override
    public void updateAppointment(Long id, Appointment updateAppointment) {
        appointmentsRepository.updateAppointment(id,updateAppointment);
    }
}
