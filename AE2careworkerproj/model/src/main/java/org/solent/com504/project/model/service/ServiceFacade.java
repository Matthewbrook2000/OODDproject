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
    
    public Person newPerson(String firstName, String secondName, String role, String address);
    
    public Appointment addAppointment(String description, Person personA, Person personB, int hr, int mth, int yr, int durationMinutes);
    
    public boolean deleteAppointment(long id);
    
    public Appointment getAppointment(long id);
    
    public Person getPerson(long id);
    
    public List<Person> getPersonByRole(Role role);
    
    public List<Appointment> getAllAppointments();
    
    public List<Appointment> getAppointmentByCarerId(long id);
    
    public List<Person> getAllPersons();
    
    public boolean finishedAppointment(); 
    
    public boolean deletePerson(long id);
    
    public Appointment updateDescription(long id, String description);
}

