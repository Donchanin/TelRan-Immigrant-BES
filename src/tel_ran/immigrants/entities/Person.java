package tel_ran.immigrants.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person", uniqueConstraints = {
		@UniqueConstraint(columnNames = "P_EMAIL")
})
public class Person {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="P_EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogInDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@OneToOne(optional=false)
	@JoinColumn(name="PERSDATA_ID", unique=true, nullable=false, updatable=false)
	private PersonData personData;
	
	@OneToMany(mappedBy="parentPerson")
	private List<FamilyMember> family;

	
	
	public Date getLastLogInDate() {
		return lastLogInDate;
	}

	public void setLastLogInDate(Date lastLogInDate) {
		this.lastLogInDate = lastLogInDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public List<FamilyMember> getFamily() {
		return family;
	}

	public void setFamily(List<FamilyMember> family) {
		this.family = family;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return registrationDate;
	}

	public void setRegDate(Date regDate) {
		this.registrationDate = regDate;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	
	public String toString(){
		return personData.getFirstName() + " " + personData.getLastName() + " " + email;
	}
}
