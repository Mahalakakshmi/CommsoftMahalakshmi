package me.app.component;

import me.app.component.ComponentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import me.app.aircraft.domain.*;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepo componentRepo;
    
  private static  List<Component>  components =new ArrayList<Component>();
       
      public List<Component> getAllComponents() {
        List<Component> components  = new ArrayList<Component>();
        componentRepo.findAll().forEach(components ::add);
        return components ;
    }

    public Component getComponentById(Integer id) {
         return componentRepo.findById(id).get();
    }

    public Component saveComponent(Component component) {
    	componentRepo.save(component);
    	return component;
    }

    public void UpdateComponent(Component component, Integer id) {
    	
    	Component existingcomponent =componentRepo.findById(id).get();
    	existingcomponent.setPartNumber(component.getPartNumber());
    	 
    	existingcomponent.setLastFitmentTime(component.getLastFitmentTime());
    	
    	existingcomponent.setNotes(component.getNotes());
    	componentRepo.save(existingcomponent);
      	
    }
    

    public void deleteById(Integer id) {
    	componentRepo.deleteById(id);
              }
   
    
    
}
      



