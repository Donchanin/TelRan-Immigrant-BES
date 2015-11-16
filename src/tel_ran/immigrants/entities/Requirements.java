package tel_ran.immigrants.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Requirements {
	
	@Id
	@GeneratedValue
	@Column(name = "REQUIREMENTS_ID")
	private long requirements_id;
	
	@Column(name = "MIN_AGE")
	private int minAge;
	
	@Column(name = "MAX_AGE")
	private int maxAge;
	
	@Column(name = "EDUCATION")
	private String education;
	
	@Column(name = "OCCUPATION")
	private String occupation;
	
	@Column(name = "MARITAL_STATUS")
	private String maritalStatus;
	
	@Column(name = "RELIGIOUS_BACKGROUND")
	private String religiousBackground;
	
	@OneToOne(optional=false, mappedBy="requiremens")	
	private Program program;
	
	@OneToMany(mappedBy="requirements")
	private List<Document> documents;
	
    @OneToMany(mappedBy="requirements")
    private List<ProgramCustomData> customData;
	
    
    
	public List<ProgramCustomData> getCustomData() {
		return customData;
	}
	public void setCustomData(List<ProgramCustomData> customData) {
		this.customData = customData;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getReligiousBackground() {
		return religiousBackground;
	}
	public void setReligiousBackground(String religiousBackground) {
		this.religiousBackground = religiousBackground;
	}
	public long getRequirements_id() {
		return requirements_id;
	}

	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public List<ProgramCustomData> getProgramCustomDatas() {
		return customData;
	}
	public void setProgramCustomDatas(List<ProgramCustomData> programCustomDatas) {
		this.customData = programCustomDatas;
	}

}
