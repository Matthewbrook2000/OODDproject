package org.solent.com504.project.model.service;

import org.solent.com504.project.model.dto.Appointment;

public interface ServiceFacade {
    
    public String getHeartbeat();
    
    public int updateHeartbeat();
    
    public Appointment arrived(String name, String location);
    
    public Appointment addAppointment();
    
    public boolean deleteAppointment();
    
    public Appointment getAppointment();
    
    public Appointment modifyAppointment();
    
    public Appointment getAllAppointments();
    
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
