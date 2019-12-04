package org.solent.com504.project.model.service;

import java.util.List;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

/**
 *
 * @author Matt- Laptop
 */
public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public int updateHeartbeat();
    
    public Person newPerson(String firstName, String secondName, String role, String address);
    
    public Appointment arrived(String name, String location);
    
    public Appointment addAppointment(String description, Person personA, Person personB, int hr, int mth, int yr, int durationMinutes);
    
    public boolean deleteAppointment(long id);
    
    public Appointment getAppointment(long id);
    
    public Person getPerson(long id);
    
    public Appointment modifyAppointment();
    
    public List<Appointment> getAllAppointments();
    
    public List<Person> getAllPersons();
    
    public boolean finishedAppointment(); 
    
    public boolean deletePerson(long id);
    
    public Appointment modifyPerson();
    
}

