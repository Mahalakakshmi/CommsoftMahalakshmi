package me.app.component;
import me.app.aircraft.domain.Aircraft;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="component")
public class Component implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="component_id")
    private Integer id;
    
   

	@Column(name="part_number")
   	 private String partNumber;
    
	@JsonFormat(pattern= "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape=Shape.STRING)
    @Column(name="last_fitment_time")
    private String LastFitmentTime;
    
    @Column(name="notes")
    private String notes;
    
    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(referencedColumnName ="aircraft_id", nullable= false, insertable = true,updatable = true)
    private Aircraft aircraft; 
    
    
       
   
    
	public Component() {}
    
    public Component(Integer id,String partNumber, String LastFitmentTime, String notes) {
    	super();
    	this.id = id;
    	this.partNumber = partNumber;
    	this.LastFitmentTime = LastFitmentTime;
    	this.notes = notes;
    	
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getLastFitmentTime() {
		return LastFitmentTime;
	}

	public void setLastFitmentTime(String lastFitmentTime) {
		LastFitmentTime = lastFitmentTime;
	}
  
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	 public String toString() {
	        return "Aircraft{" +
	                "Id=" + id +"partNumber="+partNumber+"LastFitmentTime="+LastFitmentTime
	                +"notesGiven="+notes+
	                '}';
	    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Component)) return false;
        Component component = (Component) o;
        return Objects.equals(id, component.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    }
