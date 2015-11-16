package tel_ran.immigrants.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProgramCustomData {
	
	@Id
	@GeneratedValue
	@Column(name = "PERSON_CUSTOM_DATA_ID")
	private long id;
	
	private String value;

	@ManyToOne
	@JoinColumn(name="FIELD_NAMES_ID")
	private FieldNames fieldNames;
	
	
	@ManyToOne
	@JoinColumn(name="REQUIREMENTS_ID")
	private Requirements requirements;
	
	public long getId() {
		return id;
	}
	

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public FieldNames getFieldNames() {
		return fieldNames;
	}
	public void setFieldNames(FieldNames fieldNames) {
		this.fieldNames = fieldNames;
	}


	public Requirements getRequirements() {
		return requirements;
	}


	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}


}
