package me.app.component;


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
public class ComponentController {

    @Autowired
    private ComponentService componentService ;
   @Autowired
    private ComponentRepo componentRepo;
   
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
   
   
    @GetMapping("/components")
	public List<Component>getAllAircrafts() {
		return   componentService.getAllComponents();
	}
    
    @GetMapping("/comonents/{id}")
    private Component getComponentById(@PathVariable("id") Integer id) {
        return componentService.getComponentById(id);
    }
    
    
    @PostMapping("/components")
    @ResponseStatus(HttpStatus.CREATED)
    private int saveOrUpdateAircraft(@RequestBody Component component) {
    	Component SavedAircraft= componentService.saveComponent(component);
    	
    	return(SavedAircraft.getId());
        
    }
    
    @PutMapping("/components/{id}")
    @ResponseStatus(HttpStatus.OK)
    private void updateAircraft(@PathVariable("id") int id, @RequestBody Component component) {
    	componentService.UpdateComponent(component,id);
    
    } 
    
}   
    
    
    
    
    
 



