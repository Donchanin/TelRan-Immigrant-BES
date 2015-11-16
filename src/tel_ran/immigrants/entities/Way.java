package tel_ran.immigrants.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Way {
	@Id
	@GeneratedValue
	@Column(name = "WAY_ID", unique = true, nullable = false)
	private long id;
	private Date startDate;
	private Date endDate;
	private boolean isFinished;
	
	@ManyToOne
	@JoinColumn(name = "PERSONDATA_ID", nullable = false)
	private PersonData personData;
	
	@ManyToOne
	@JoinColumn(name="PROGRAM_ID",nullable = false)
	private Program program;
	
    @OneToMany(mappedBy="way")
    private List<WaySteps> waySteps;
    
    @OneToMany(mappedBy="way")
    private List<WayDocuments> waydocuments;
    
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	public long getId() {
		return id;
	}
	public PersonData getPersonData() {
		return personData;
	}
	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	public List<WaySteps> getWaySteps() {
		return waySteps;
	}
	public void setWaySteps(List<WaySteps> waySteps) {
		this.waySteps = waySteps;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public List<WayDocuments> getWaydocuments() {
		return waydocuments;
	}
	public void setWaydocuments(List<WayDocuments> waydocuments) {
		this.waydocuments = waydocuments;
	}


}
