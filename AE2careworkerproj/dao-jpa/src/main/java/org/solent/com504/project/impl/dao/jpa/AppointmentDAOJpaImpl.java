package org.solent.com504.project.impl.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;

public class AppointmentDAOJpaImpl implements AppointmentDAO {

    final static Logger LOG = LogManager.getLogger(PersonDAOJpaImpl.class);

    private EntityManager entityManager;

    public AppointmentDAOJpaImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Appointment findById(Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        return appointment;
    }

    @Override
    public Appointment save(Appointment appointment) {
        entityManager.getTransaction().begin();
        entityManager.persist(appointment);  
        entityManager.getTransaction().commit();
        return appointment;
    }

    @Override
    public List<Appointment> findAll() {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a FROM Appointment a", Appointment.class);
        List<Appointment> appointmentList = q.getResultList();
        return appointmentList;
    }

    @Override
    public Appointment delete(Appointment appointment) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Appointment a WHERE a=:appointment").setParameter("appointment", appointment).executeUpdate();  
        entityManager.getTransaction().commit();
        return appointment;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("DELETE FROM Appointment a WHERE a.id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Appointment ").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Appointment> findByPersonA(Person personA) {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a FROM Appointment a WHERE a.personA=:personA", Appointment.class).setParameter("personA", personA);
        List<Appointment> AppointmentList = q.getResultList();
        return AppointmentList;
    }

    @Override
    public List<Appointment> findByPersonB(Person personB) {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a FROM Appointment a WHERE a.personB=:personB", Appointment.class).setParameter("personB", personB);
        List<Appointment> AppointmentList = q.getResultList();
        return AppointmentList;
    }

    @Override
    public List<Appointment> findByDate(Integer year, Integer month, Integer hour, Integer minutes) {
        TypedQuery<Appointment> q = entityManager.createQuery("SELECT a FROM Appointment a WHERE a.yr=:yr AND a.mth=:mth AND a.hr=:hr AND a.durationMinutes=:mins", Appointment.class).setParameter("yr", year).setParameter("mth", month).setParameter("hr", hour).setParameter("mins", minutes);
        List<Appointment> appointmentList = q.getResultList();
        return appointmentList;
    }

}
