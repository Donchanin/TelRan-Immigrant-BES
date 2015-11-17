package tel_ran.immigrants.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Program {
	
	
	@Id
	@GeneratedValue
	@Column(name = "PROGRAM_ID")
	private long id;
	
	@Column(name = "PROGRAM_NAME")
	private String name;
	
	@Column(name = "PROGRAM_CATEGORY")
	private String category;
	
	@Column(name = "PROGRAM_LINK")
	private String link;
	
	@Column(name = "PROGRAM_DESCRIPTION", length=2000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country progr_country;
	
	@OneToOne
	@JoinColumn(name="REQUIREMENTS_ID", unique=true,nullable = true)
	private Requirements requiremens;
		   

    @OneToMany(mappedBy = "program")
    private List<ProgramSteps> stepsToDo;
    
    

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Country getProgr_country() {
//		return progr_country;
//	}
//
//	public void setProgr_country(Country progr_country) {
//		this.progr_country = progr_country;
//	}


	public Requirements getRequiremens() {
		return requiremens;
	}


	public void setRequiremens(Requirements requiremens) {
		this.requiremens = requiremens;
	}

	public List<ProgramSteps> getProgramSteps() {
		return stepsToDo;
	}


	public void setProgramSteps(List<ProgramSteps> programSteps) {
		this.stepsToDo = programSteps;
	}


}
