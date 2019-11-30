package org.solent.com504.project.impl.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.AppointmentDAO;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;
import org.solent.com504.project.model.service.ServiceFacade;

public class ServiceFacadeImpl implements ServiceFacade {
        final static Logger LOG = LogManager.getLogger(ServiceFacadeImpl.class);

    private PersonDAO personDao = null;

    private AppointmentDAO appointmentDao = null;
    
       // used to concurently count heartbeat requests
    private static AtomicInteger heartbeatRequests = new AtomicInteger();

    // setters for DAOs
    public void setPersonDao(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public void setAppointmentDao(AppointmentDAO appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    // Service facade methods

    @Override
    public String getHeartbeat() {
        return "heartbeat number "+heartbeatRequests.getAndIncrement()+ " "+ new Date().toString();
    }
    @Override
    public Appointment arrived(String name, String location) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    //rest works, sends error end to end but the logic behind adding a new appointment doesnt work.
//        if (name == null || name.isEmpty()) {
//            throw new IllegalArgumentException("name cannot be null or empty ");
//        }
//        if (location == null || location.isEmpty()) {
//            throw new IllegalArgumentException("location cannot be null");
//        }
//        Appointment appointment = new Appointment(); 
//        Appointment appointment = appointmentDao.save(appointment);
//        appointmentDao.save(appointment);
//        return appointment;
    }

    @Override
    public int updateHeartbeat() {
        //try update time
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAppointment(long id) {
         if (id == 0) {
            throw new IllegalArgumentException("name cannot be null");
        }
        Appointment appointment = getAppointment(id);
        if (appointment != null) {
            appointmentDao.deleteById(id);
            return true;
        }
        
        return false;
    }

    @Override
    public Appointment getAppointment(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("id cannot be 0");
        }
        Appointment appointmentTemp = appointmentDao.findById(id);
        
        return appointmentTemp;
        
    }

    @Override
    public Appointment modifyAppointment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDao.findAll();
    }

    @Override
    public boolean finishedAppointment() {
        //Rest
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Appointment addAppointment(String description, Person personA, Person personB, long id, int hr, int mth, int yr, int durationMinutes) {
        
          if (description == null){
              throw new IllegalArgumentException("description cannot be null");
          }
          if (personA == null){
              throw new IllegalArgumentException("personA cannot be null");
          }
          if (personB == null){
              throw new IllegalArgumentException("personB cannot be null");
          }         
        
        Appointment appointment = new Appointment();
        appointment.setDescripton(description);
        appointment.setDurationMinutes(durationMinutes);
        appointment.setHr(hr);
        appointment.setId(id);
        appointment.setMth(mth);
        appointment.setPersonA(personA);
        appointment.setPersonB(personB);
        appointment.setYr(yr);
        appointmentDao.save(appointment);
        return appointment;
    }

    @Override
    public Person newPerson(Long id, String firstName, String secondName, Role role, String address) {
        if (firstName == null){
            throw new IllegalArgumentException("first name cannot be null");
        }
        if (secondName == null){
              throw new IllegalArgumentException("second name cannot be null");
          }         
        
        Person person = new Person();
        person.setAddress(address);
        person.setFirstName(firstName);
        person.setSecondName(secondName);
        person.setId(id);
        person.setRole(role);
        personDao.save(person);
        return person;
    }

    @Override
    public Person getPerson(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("id cannot be 0");
        }
        Person personTemp = personDao.findById(id);
        
        return personTemp;
    }

    

}
