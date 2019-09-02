package me.app.aircraft.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import me.app.component.*;
import me.app.flight.*;

@Entity
@Table(name="aircraft")
public class Aircraft implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="aircraft_id")
    private Integer id;
    
    @Column(name="reg_code")
    private String registrationCode;
    
    @Column(name="enabled")
    private boolean enabled;
    
    @Column(name="notes")
    private String notes;
    
    //@OneToMany(mappedBy ="registrationCode",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL,mappedBy ="aircraft")
    private List<Component> components;
   
    @OneToMany(cascade=CascadeType.ALL,mappedBy ="aircraft")
    private List<Flight> flights;
    
    public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	
	
	public Aircraft() {}
    
    public Aircraft(Integer id,String registrationCode, boolean enabled, String notes) {
    	super();
    	this.id = id;
    	this.registrationCode = registrationCode;
    	this.enabled = enabled;
    	this.notes = notes;
    	
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
  
    public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	 public String toString() {
	        return "Aircraft{" +
	                "Id=" + id +"regCode="+registrationCode+"abled="+enabled
	                +"notesGiven="+notes+
	                '}';
	    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aircraft)) return false;
        Aircraft aircraft = (Aircraft) o;
        return Objects.equals(id, aircraft.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    }
