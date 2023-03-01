package peaksoft.service;

import peaksoft.entities.Appointment;
import peaksoft.entities.Department;

import java.util.List;

public interface AppointmentsService {
    void saveAppointment( Long hospitalId,Appointment appointment);
    List<Appointment> getAllAppointment(Long id);
    Appointment getAppointmentById(Long id);
    void deleteAppointmentById(Long id,Long hospitalId);
    void updateAppointment(Long id,Appointment updateAppointment);


}
