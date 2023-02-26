package peaksoft.repository.Impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entities.*;
import peaksoft.repository.AppointmentsRepository;
import peaksoft.service.AppointmentsService;

import java.util.List;

@Repository
@Transactional
public class AppointmentsRepoImpl implements AppointmentsRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Appointment saveAppointment( Appointment appointment) {
        entityManager.persist(appointment);
        return appointment;
    }

    @Override
    public List<Appointment> getAllAppointment(Long id) {
        return entityManager.createQuery("select a from Hospital h join h.appointments a where h.id= :id", Appointment.class).
                setParameter("id",id).getResultList();
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return entityManager.find(Appointment.class,id);
    }

    @Override
    public void deleteAppointmentById(Long id) {
  entityManager.createQuery("delete  from Appointment  where id= :id", Department.class).setParameter("id",id).executeUpdate();
    }

    @Override
    public void updateAppointment(Long id, Appointment updateAppointment) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        appointment.setDate(updateAppointment.getDate());
        entityManager.merge(appointment);
    }
}
