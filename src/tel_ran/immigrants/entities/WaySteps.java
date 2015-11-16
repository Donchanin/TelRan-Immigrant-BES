package tel_ran.immigrants.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class WaySteps {
	
	@Id
	@GeneratedValue
	@Column(name = "WAY_STEPS_ID")
	private long id;
	
	private boolean isDone;
	
	@Column(length=2000)
	private String information;
	
	
	@ManyToOne
	@JoinColumn(name="WAY_ID", nullable=false)
	private Way way;
	
	@ManyToOne
	@JoinColumn(name = "PROGRAM_STEPS_ID",nullable=false)
	private ProgramSteps programSteps;
	
	public long getId() {
		return id;
	}

	
	
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}

	public Way getWay() {
		return way;
	}

	public void setWay(Way way) {
		this.way = way;
	}

	public ProgramSteps getProgramSteps() {
		return programSteps;
	}

	public void setProgramSteps(ProgramSteps programSteps) {
		this.programSteps = programSteps;
	}

}
