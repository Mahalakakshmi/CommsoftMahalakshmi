package me.app.aircraft.controller;

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
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;
   @Autowired
    private AircraftRepo aircraftRepo;
   
/*
    @GetMapping("/aircrafts/{id}")
    public ResponseEntity<BigDecimal> getSpecificAircraft(@NotNull @PathVariable("aircraftID") final Integer aircraftID) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/aircrafts")
    public ResponseEntity<BigDecimal> getAllAircraft() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    
    
    
    @PostMapping("/airsrafts")
    private int saveAircraft(@RequestBody Aircraft aircraft) {
        aircraftService.saveOrUpdate(aircraft);
        return aircraft.getId();
    }
    
    
    */
   
   
    @GetMapping("/aircrafts")
	public List<Aircraft>getAllAircrafts() {
		return   aircraftService.getAllAircrafts();
	}
    
    @GetMapping("/aircrafts/{id}")
    private Aircraft getAircraftById(@PathVariable("id") int id) {
        return aircraftService.getAircraftById(id);
    }
    
    
    @PostMapping("/aircrafts")
    @ResponseStatus(HttpStatus.CREATED)
    private int saveOrUpdateAircraft(@RequestBody Aircraft aircraft) {
    	Aircraft SavedAircraft= aircraftService.saveOrUpdateAircraft(aircraft);
    	
    	return(SavedAircraft.getId());
        
    }
    
    @PutMapping("/aircrafts/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateAircraft(@PathVariable("id") int id, @RequestBody Aircraft aircraft) {
    	 aircraftService.UpdateAircraft(id, aircraft);
    
    } 
    
}   
    
    
    
    
    
 



