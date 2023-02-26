package peaksoft.service;

import peaksoft.entities.Appointment;
import peaksoft.entities.Department;

import java.util.List;

public interface AppointmentsService {
    Appointment saveAppointment( Long id,Appointment appointment);
    List<Appointment> getAllAppointment(Long id);
    Appointment getAppointmentById(Long id);
    void deleteAppointmentById(Long id);
    void updateAppointment(Long id,Appointment updateAppointment);


}
