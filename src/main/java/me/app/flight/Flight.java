package me.app.flight;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import me.app.aircraft.domain.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="flight")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
         
    @Column(name="flight_id")
    private Integer id;
    
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(referencedColumnName ="aircraft_id", nullable= false, insertable = true,updatable = true)
        
    private Aircraft aircraft;    
    
    @Column(name="reg_code")
    String registraionCode;
    
   	@JsonFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape =Shape.STRING)
    @Column(name="takeoff")
    String takeoff;
    
    
      
    @JsonFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape =Shape.STRING)
    @Column(name="landing")
    String landing;
   
    @Column(name="aircraft_id")
     private Integer aircraftId; 
    
    
    public Flight() {}
    
    public Flight(Integer id) {
    	super();
    	this.id = id;
    	    }
    
    
    public Integer getId() {
        return id;
    }
	public void setId(Integer id) {
        this.id = id;
    }
    
    public String getTakeoff() {
    	return takeoff;
	}

	public void setTakeoff(String takeoff) {
		this.takeoff = takeoff;
	}

	public String getLanding() {
		return landing;
	}

	public void setLanding(String landing) {
		this.landing = landing;
	}
	
	 public Integer getAircraftId() {
			return aircraftId;
		}

		public void setAircraftId(Integer aircraftId) {
			this.aircraftId = aircraftId;
		}
		
		
    
	public String getRegistraionCode() {
			return registraionCode;
		}

		public void setRegistraionCode(String registraionCode) {
			this.registraionCode = registraionCode;
		}



  
  

	 public String toString() {
	        return "Aircraft{" +
	                "Id=" + id +"takeoff"+takeoff+
	                "landing"+landing+"registrationCode"+ registraionCode +"aircraftId"+aircraftId+
	                '}';
	    }
	 
	
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    }
