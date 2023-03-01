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
    public void saveAppointment( Long hospitalId,Appointment appointment) {
        Hospital hospital = hospitalRepository.getHospitalById(hospitalId);
        Appointment newAppointment=new Appointment();
        newAppointment.setDate(appointment.getDate());
        newAppointment.setPatient(patientsRepository.getPatientById(appointment.getPatientId()));
        appointment.setDepartment(departmentRepository.getDepartmentById(appointment.getDepartmentId()));
        appointment.setDoctor(doctorsRepository.getByDoctorId(appointment.getDepartmentId()));
        hospital.addAppointment(newAppointment);
        appointmentsRepository.saveAppointment(newAppointment);

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
    public void deleteAppointmentById(Long id,Long hospitalId) {
        Appointment appointment= appointmentsRepository.getAppointmentById(id);
        hospitalRepository.getHospitalById(hospitalId).getAppointments().remove(appointment);
        appointment.getDoctor().getAppointments().remove(appointment);
        appointment.getPatient().getAppointments().remove(appointment);
        appointmentsRepository.deleteAppointmentById(id);
    }

    @Override
    public void updateAppointment(Long id, Appointment updateAppointment) {
        appointmentsRepository.updateAppointment(id,updateAppointment);
    }
}
