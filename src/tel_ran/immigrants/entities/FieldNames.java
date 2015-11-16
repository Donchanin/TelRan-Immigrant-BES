package tel_ran.immigrants.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="FieldNames", uniqueConstraints = {
		@UniqueConstraint(columnNames="NAME")
})
public class FieldNames {
	
	@Id
	@GeneratedValue
	@Column(name = "FIELD_NAMES_ID")
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(length=2000)
	private String possibleValues;
	
    @OneToMany(mappedBy="fieldNames")
    private List<PersonCustomData> personValues;
    
    @OneToMany(mappedBy="fieldNames")
    private List<ProgramCustomData> programValues;
	
        
	public List<PersonCustomData> getPersonValues() {
		return personValues;
	}
	public void setPersonValues(List<PersonCustomData> personValues) {
		this.personValues = personValues;
	}
	public List<ProgramCustomData> getProgramValues() {
		return programValues;
	}
	public void setProgramValues(List<ProgramCustomData> programValues) {
		this.programValues = programValues;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public List<PersonCustomData> getPersonCustomData() {
		return personValues;
	}
	public void setPersonCustomData(List<PersonCustomData> personCustomData) {
		this.personValues = personCustomData;
	}
	public String getPossibleValues() {
		return possibleValues;
	}
	public void setPossibleValues(String possibleValues) {
		this.possibleValues = possibleValues;
	}
	public List<ProgramCustomData> getProgramCustomData() {
		return programValues;
	}
	public void setProgramCustomData(List<ProgramCustomData> programCustomData) {
		this.programValues = programCustomData;
	}

}
