package org.solent.com504.project.model.service;

import org.solent.com504.project.model.dto.Appointment;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public Appointment arrived(String name, String location);
    
    
}
