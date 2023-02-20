//package peaksoft.repository.Impl;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Repository;
//import peaksoft.entities.Appointment;
//import peaksoft.service.AppointmentsService;
//
//import java.util.List;
//
//@Repository
//@Transactional
//public class AppointmentsRepoImpl implements AppointmentsService {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public void saveAppointment(Appointment appointment) {
//        entityManager.persist(appointment);
//    }
//
//    @Override
//    public List<Appointment> getAllAppointment() {
//        return entityManager.createQuery("select a from Appointment a",Appointment.class).getResultList();
//    }
//
//    @Override
//    public Appointment getAppointmentById(Long id) {
//        return entityManager.find(Appointment.class,id);
//    }
//
//    @Override
//    public void deleteAppointmentById(Long id) {
//        Appointment appointment = entityManager.find(Appointment.class, id);
//        entityManager.remove(appointment);
//    }
//
//    @Override
//    public void updateAppointment(Long id, Appointment updateAppointment) {
//
//    }
//}
