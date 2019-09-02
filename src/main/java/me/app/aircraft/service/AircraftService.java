package me.app.aircraft.service;

import me.app.aircraft.repo.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import me.app.aircraft.domain.*;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepo aircraftRepo;
    
  private static  List<Aircraft>  aircrafts =new ArrayList<Aircraft>();
       
      public List<Aircraft> getAllAircrafts() {
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();
       // aircraftRepo.findAll().forEach(Aircraft ->aircrafts.add(aircraft));
        aircraftRepo.findAll().forEach(aircrafts::add);
        return aircrafts;
    }

    public Aircraft getAircraftById(Integer id) {
         return aircraftRepo.findById(id).get();
    }

    public Aircraft saveOrUpdateAircraft(Aircraft aircraft) {
    	aircraftRepo.save(aircraft);
    	return aircraft;
    }

    public void UpdateAircraft(Integer id,Aircraft aircraft) {
    	
    	Aircraft existingAircraft =aircraftRepo.findById(id).get();
    	existingAircraft.setRegistrationCode(aircraft.getRegistrationCode());
    	 
    	existingAircraft.setRegistrationCode(aircraft.getRegistrationCode());
    	existingAircraft.setEnabled(aircraft.isEnabled());
    	existingAircraft.setNotes(aircraft.getNotes());
    	aircraftRepo.save(existingAircraft);
      	
    }
    

    public void deleteById(Integer id) {
        aircraftRepo.deleteById(id);
              }
   
    
    
}
      



