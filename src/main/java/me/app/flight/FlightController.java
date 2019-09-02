package me.app.flight;

import me.app.aircraft.domain.Aircraft;
import me.app.aircraft.repo.AircraftRepo;
import me.app.aircraft.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;

//import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.net.URI;

@RestController
public class FlightController {
   
   @Autowired
   private FlightService flightService;
   
   
    @GetMapping("/flights")
	public List<Flight>getAllFlights() {
		return   flightService.getAllFlights();
	}
    
    @GetMapping("/flights/{id}")
    private Flight getFlightById(@PathVariable("id") int id) {
        return flightService.getFlightById(id);
    }
    
    
    @PostMapping("/flights")
    @ResponseStatus(HttpStatus.CREATED)
    private int saveFlight(@RequestBody Flight flight) {
    	Flight savedFlight= flightService.saveFlight(flight);
    	
    	return(savedFlight.getId());
        
    }
    
    @PutMapping("/flights/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateFlight(@PathVariable("id") int id, @RequestBody Flight flight) {
    	flightService.UpdateFlight(id, flight);
    
    } 
    
}   
    
    
    
    
    
 



