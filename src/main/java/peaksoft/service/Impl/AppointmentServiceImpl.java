//package peaksoft.service.Impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import peaksoft.entities.Appointment;
//import peaksoft.repository.AppointmentsRepository;
//import peaksoft.service.AppointmentsService;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class AppointmentServiceImpl implements AppointmentsService {
//
//    private final AppointmentsRepository appointmentsRepository;
//    @Override
//    public void saveAppointment(Appointment appointment) {
//        appointmentsRepository.saveAppointment(appointment);
//    }
//
//    @Override
//    public List<Appointment> getAllAppointment() {
//        return appointmentsRepository.getAllAppointment();
//    }
//
//    @Override
//    public Appointment getAppointmentById(Long id) {
//        return appointmentsRepository.getAppointmentById(id);
//    }
//
//    @Override
//    public void deleteAppointmentById(Long id) {
//        appointmentsRepository.deleteAppointmentById(id);
//    }
//
//    @Override
//    public void updateAppointment(Long id, Appointment updateAppointment) {
//
//    }
//}
