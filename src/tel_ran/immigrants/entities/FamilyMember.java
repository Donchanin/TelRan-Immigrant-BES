package tel_ran.immigrants.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FamilyMember {

	@Id
	@GeneratedValue
	@Column(name = "FAMILY_ID")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person parentPerson;
		
	@OneToOne
	@JoinColumn(name="PERSDATA_ID", unique=true, updatable=false)
	private PersonData personData;
	 
	@Column(name = "RELATION")
	String relation;

	
	
	public long getId() {
		return id;
	}

	public Person getParentPerson() {
		return parentPerson;
	}

	public void setParentPerson(Person parentPerson) {
		this.parentPerson = parentPerson;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}		
}
