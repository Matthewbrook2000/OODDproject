/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.service.test;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.project.impl.service.ServiceObjectFactoryJpaImpl;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;
import org.solent.com504.project.model.service.ServiceFacade;
import org.solent.com504.project.model.service.ServiceObjectFactory;


/**
 *
 * @author gallenc
 */
public class ServiceFacadeJpaTest {
    
    ServiceObjectFactory serviceObjectFactory = null;
    ServiceFacade serviceFacade = null;


    @Before
    public void loadFactory() {

        serviceObjectFactory = new ServiceObjectFactoryJpaImpl();
        
        serviceFacade = serviceObjectFactory.getServiceFacade();

    }

    @Test
    public void testFactory() {
        System.out.println("start ServiceFacadeTest testFactory");
        assertNotNull(serviceFacade);

        System.out.println("end ServiceFacadeTest testFactory");
    }

    @Test
    public void testGetHeartbeat() {
        System.out.println("start ServiceFacadeTest testGetHeartbeat()");
        assertNotNull(serviceFacade);
        
        String heartbeat = serviceFacade.getHeartbeat();
        System.out.println("recieved heartbeat: "+heartbeat);
        assertNotNull(heartbeat);
        
        System.out.println("end FarmFacadeTest testGetHeartbeat()");
    }

    // WHAT OTEHR TESTS DO YOU NEED FOR HE SERVICE?
    @Test
    public void testAddAppointment(){
        System.out.println("start ServiceFacadeTest testGetHeartbeat()");
        assertNotNull(serviceFacade);
        
        Person personA = serviceFacade.newPerson("steve", "harrington", "Patient", "that place");
        Person personB = serviceFacade.newPerson("john", "something", "Patient", "this place");
        
        Appointment appointment = serviceFacade.addAppointment("test", personA, personB, 1, 1, 1, 30) ;
        
        assertNotNull(appointment);
    }
    
    @Test
    public void testNewPerson(){
        System.out.println("start ServiceFacadeTest testNewPerson()");
        assertNotNull(serviceFacade);
        
        Person person = serviceFacade.newPerson("john", "doe", "Patient", "123 street");
        
        assertNotNull(person);
        System.out.println("end ServiceFacadeTest testNewPerson()");
    }
    
    @Test
    public void testGetAppointment(){
        System.out.println("start ServiceFacadeTest testGetAppointment()");
        
        Person person = serviceFacade.newPerson("john", "doe", "Patient", "123 street");
        Person personn = serviceFacade.newPerson("ghgh", "ghoe", "Patient", "1ghght");
        
        Appointment appointment = serviceFacade.addAppointment("test", person, personn, 1, 1, 1, 30) ;
        
        long id = appointment.getId();
        System.out.println("id is: " + id);
        Appointment gotAppointment = serviceFacade.getAppointment(id);
        
       // assertNotNull(gotAppointment);
        System.out.println(gotAppointment);
        
        System.out.println("end ServiceFacadeTest testGetAppointment()");
    }
    
    @Test
    public void testDeleteAppointment(){
        System.out.println("start ServiceFacadeTest testDeleteAppointment()");
        assertNotNull(serviceFacade);
        
        testAddAppointment();
        
        serviceFacade.deleteAppointment(2L);
        Appointment gotAppointment = serviceFacade.getAppointment(2L);
        assertNull(gotAppointment);

        System.out.println("end ServiceFacadeTest testDeleteAppointment()");
    }
    
    @Test
    public void testGetAllAppointments(){
        System.out.println("start ServiceFacadeTest testGetAllAppointment()");
        assertNotNull(serviceFacade);
        
        testAddAppointment();
        
        List<Appointment> appointmentList = serviceFacade.getAllAppointments();
        assertNotNull(appointmentList);
  
        System.out.println("end ServiceFacadeTest testGetAllAppointment()");
    }
    
    @Test
    public void testGetAllPersons(){
    System.out.println("start ServiceFacadeTest testGetAllAppointment()");
        assertNotNull(serviceFacade);
        
        testNewPerson();
        
        List<Person> personList = serviceFacade.getAllPersons();
        assertNotNull(personList);
  
        System.out.println("end ServiceFacadeTest testGetAllAppointment()");
    }
}
