package tel_ran.immigrants.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ProgramSteps {
	
	@Id
	@GeneratedValue
	@Column(name = "PROGRAM_STEP_ID")
	private long id;
	
	private String stepType;
	
	@Column(length=2000)
	private String about;
		
	@ManyToOne
	@JoinColumn(name="PROGRAM_ID")
	private Program program;
	
//    @OneToMany(mappedBy="programSteps")
//    private List<WaySteps> waysteps;
	
	public long getId() {
		return id;
	}

	public String getStepType() {
		return stepType;
	}

	public void setStepType(String stepType) {
		this.stepType = stepType;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

//	public List<WaySteps> getWaysteps() {
//		return waysteps;
//	}
//
//	public void setWaysteps(List<WaySteps> waysteps) {
//		this.waysteps = waysteps;
//	}



}
