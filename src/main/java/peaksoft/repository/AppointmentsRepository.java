package peaksoft.repository;

import peaksoft.entities.Appointment;

import java.util.List;

public interface AppointmentsRepository {
    Appointment saveAppointment(Appointment appointment);
    List<Appointment> getAllAppointment(Long id);
    Appointment getAppointmentById(Long id);
    void deleteAppointmentById(Long id);

    void updateAppointment(Long id,Appointment updateAppointment);

}
