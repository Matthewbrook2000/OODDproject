package org.solent.com504.project.model.service;

import java.util.List;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public int updateHeartbeat();
    
    public Person newPerson(Long id, String firstName, String secondName, Role role, String address);
    
    public Appointment arrived(String name, String location);
    
    public Appointment addAppointment(String description, Person personA, Person personB, long id, int hr, int mth, int yr, int durationMinutes);
    
    public boolean deleteAppointment(long id);
    
    public Appointment getAppointment(long id);
    
    public Person getPerson(long id);
    
    public Appointment modifyAppointment();
    
    public List<Appointment> getAllAppointments();
    
    public List<Person> getAllPersons();
    
    public boolean finishedAppointment(); //description, personA, personB, id, hr, mth, yr, durationMinutes
    
    
    /**
     * *CALL CENTER*
     load appointments  
     retrieve all appointments *
     * modify appointment *
     * Delete appointment * 
     * add new appointment *
     * retrieve appointment *
     * 
     * *CARE WORKER*
     * arrived at appointment *
     * Update time *
     * finished appointment 
     **/
}

