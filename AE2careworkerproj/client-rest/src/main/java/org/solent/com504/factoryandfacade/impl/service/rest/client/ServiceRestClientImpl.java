/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.rest.client;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.ReplyMessage;
import org.solent.com504.project.model.dto.Role;
import org.solent.com504.project.model.service.ServiceFacade;

/**
 *
 * @author gallenc
 */
public class ServiceRestClientImpl implements ServiceFacade {

    final static Logger LOG = LogManager.getLogger(ServiceRestClientImpl.class);

    String baseUrl = "http://localhost:8084/projectfacadeweb/rest/appointmentService";

    public ServiceRestClientImpl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getHeartbeat() {
        LOG.debug("getHeartbeat() Called");

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target(baseUrl).path("getHeartbeat");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();

        ReplyMessage replyMessage = response.readEntity(ReplyMessage.class);
        LOG.debug("Response status=" + response.getStatus() + " ReplyMessage: " + replyMessage);
        
        if(replyMessage==null) return null;
        
        return replyMessage.getDebugMessage();

    }
    
    @Override
    public List<Appointment> getAllAppointments() {
        LOG.debug("getAllAppointments Called");
        List<Appointment> appointmentList = null;

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target(baseUrl).path("getAllAppointments");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();

        ReplyMessage replyMessage = response.readEntity(ReplyMessage.class);
        LOG.debug("Response status=" + response.getStatus() + " ReplyMessage: " + replyMessage);

        appointmentList = replyMessage.getAppointmentList();

        return appointmentList;
    }
    
    @Override
    public List<Appointment> getAppointmentByCarerId(long id) {
        LOG.debug("getAppointmentByCarerId Called");
        List<Appointment> appointmentList = null;

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target(baseUrl).path("getAppointmentByCarerId").queryParam("id", id);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.get();

        ReplyMessage replyMessage = response.readEntity(ReplyMessage.class);
        LOG.debug("Response status=" + response.getStatus() + " ReplyMessage: " + replyMessage);

        appointmentList = replyMessage.getAppointmentList();

        return appointmentList;
    }
    
    @Override
    public boolean deleteAppointment(long id) { // doesnt work yet
        LOG.debug("DeleteAppointment Called");

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target(baseUrl).path("DeleteAppointment");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.delete();

        ReplyMessage replyMessage = response.readEntity(ReplyMessage.class);
        LOG.debug("Response status=" + response.getStatus() + " ReplyMessage: " + replyMessage);

        return true;
    }
    
    @Override
    public Appointment updateDescription(long id, String description) {
        LOG.debug("updateDescription Called");
        Appointment appointment = null;

        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target(baseUrl).path("ModifyDescription");
        
        String stringId = Long.toString(id);
        
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();
        formData.add("id", stringId);
        formData.add("description", description);
        
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Response response = invocationBuilder.post(Entity.form(formData));

        ReplyMessage replyMessage = response.readEntity(ReplyMessage.class);
        LOG.debug("Response status=" + response.getStatus() + " ReplyMessage: " + replyMessage);


        return appointment; //returns null for now
    }

    @Override
    public Appointment addAppointment(String description, Person personA, Person personB, int hr, int mth, int yr, int durationMinutes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Appointment getAppointment(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean finishedAppointment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person newPerson(String firstName, String secondName, String role, String address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersonByRole(Role role) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getAllPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePerson(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
