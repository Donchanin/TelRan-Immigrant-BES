package tel_ran.immigrants.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PersonCustomData {
	@Id
	@GeneratedValue
	@Column(name = "PERSON_CUSTOM_DATA_ID")
	private long id;
	
	private String value;
		
	@ManyToOne
	@JoinColumn(name="FIELD_NAMES_ID")
	private FieldNames fieldNames;
		
	@ManyToOne
	@JoinColumn(name="PERSDATA_ID")
	private PersonData personData;

	
	
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
	public PersonData getPersonData() {
		return personData;
	}
	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}


}
