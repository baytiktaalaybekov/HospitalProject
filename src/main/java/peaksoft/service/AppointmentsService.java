package peaksoft.service;

import peaksoft.entities.Appointment;
import peaksoft.entities.Department;

import java.util.List;

public interface AppointmentsService {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointment();

    Appointment getAppointmentById(Long id);
    void deleteAppointmentById(Long id);

    void updateAppointment(Long id,Appointment updateAppointment);


}
