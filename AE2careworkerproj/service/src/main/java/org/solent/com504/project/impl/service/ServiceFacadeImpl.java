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
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty ");
        }
        if (location == null || name.isEmpty()) {
            throw new IllegalArgumentException("location cannot be null");
        }

        Appointment appointment = AppointmentDAO
        
        AppointmentDAO
        return animal;
    }
    
}
