/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.factoryandfacade.impl.service.rest.client.test.manual;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.factoryandfacade.impl.service.rest.client.ClientObjectFactoryImpl;
import org.solent.com504.project.model.dto.Appointment;
import org.solent.com504.project.model.service.ServiceFacade;
import org.solent.com504.project.model.service.ServiceObjectFactory;

/**
 *
 * @author gallenc
 */
public class RestClientServiceFacadeTest {

    final static Logger LOG = LogManager.getLogger(RestClientServiceFacadeTest.class);

    ServiceObjectFactory serviceObjectFactory = null;
    ServiceFacade serviceFacade = null;

    List<String> supportedAnimalTypes = null;

    @Before
    public void loadFactory() {
        serviceObjectFactory = new ClientObjectFactoryImpl();
        serviceFacade = serviceObjectFactory.getServiceFacade();
        assertNotNull(serviceFacade);
    }

    @Test
    public void testGetHeartbeat() {
        LOG.debug("start of testGetHeartbeat()");

        String heartbeat = serviceFacade.getHeartbeat();
        assertNotNull(heartbeat);
        LOG.debug("heartbeat received :" + heartbeat);

        LOG.debug("end of testGetHeartbeat()");
    }
//    
//    @Test 
//    public void testArrived(){
//        LOG.debug("testArrived()");
//        String name = "name";
//        String location = "location";
//        Appointment appointment = serviceFacade.arrived(name, location);
//        assertNotNull(appointment);
//        String msg = "returned :" + appointment;
//        LOG.debug(msg);
//        LOG.debug("end of testAddAnimal()");
//    }
    @Test
    public void testGetAllAppointments(){
        LOG.debug("start of testGetAllAppointments()");
        String msg = "returned :";
        List<Appointment> appointments = serviceFacade.getAllAppointments();
        for (Appointment value : appointments) {
            msg = msg + value + ",";
        }
        assertNotNull(appointments);
        LOG.debug("end of testGetAllAnimals()");
    }
    
    @Test
    public void testDeleteAppointment(){
        LOG.debug("start of testGetAllAppointments()");
        
        LOG.debug("end of testGetAllAnimals()");
    }
}
