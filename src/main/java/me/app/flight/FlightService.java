package me.app.flight;

import me.app.flight.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import me.app.aircraft.domain.*;

@Service
public class FlightService {

    //@Autowired
    //private AircraftRepo aircraftRepo;
    
    @Autowired
    private FlightRepo flightRepo;
    
    @Autowired
    private Flight flight;
    
 //   @Autowired
   //private Aircraft aircraft;
    
    private static List<Flight> flights = new ArrayList<Flight>();   
   
      
      public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<Flight>();
        flightRepo.findAll().forEach(flights::add);
        return flights;
    }

    public Flight getFlightById(Integer id) {
         return flightRepo.findById(id).get();
    }

    public Flight saveFlight(Flight flight) {
    	flightRepo.save(flight);
    	return flight;
    }

    public void UpdateFlight(Integer id,Flight flight) {
     	Flight existingFlight =flightRepo.findById(id).get();
    	flightRepo.save(existingFlight);
      	
    }
    

    public void deleteById(Integer id) {
        flightRepo.deleteById(id);
              }
   
    
    
}
      



