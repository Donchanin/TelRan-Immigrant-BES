package tel_ran.immigrants.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonData {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String identify; //document of person. passport or civil ID
	private String firstName;
	private String lastName;
	private char gender;
	private String familyStatus;
	private String workPhone;
	private String mobilePhone;
	private String homePhone;
	private String occupation;
	private String edducation;
	
	@OneToOne(optional=true, mappedBy="personData")	
	Person person;
	
	@ManyToOne
	@JoinColumn(name = "BIRTHPLACE_COUNTRY_ID")
	private Country birthPlace; 
	
//    @OneToOne(optional=true, mappedBy="personData")
//    private FamilyMember familyMember;
    
    @OneToMany(mappedBy="personData")
    private List<Address> addresses;
    
    @OneToMany(mappedBy="personData")
    private List<PersonCustomData> personCustomDatas;
    
    @OneToMany(mappedBy = "personData")
    private List<PersonDocuments> programs;
    
    @OneToMany(mappedBy="personData")
    private List<Way> programWays;

	@ManyToMany
	private List<Country> citizenships;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;
	
	
	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public List<PersonDocuments> getPrograms() {
		return programs;
	}

	public void setPrograms(List<PersonDocuments> programs) {
		this.programs = programs;
	}

	public List<Way> getProgramWays() {
		return programWays;
	}

	public void setProgramWays(List<Way> programWays) {
		this.programWays = programWays;
	}

	public List<Country> getCitizenships() {
		return citizenships;
	}

	public void setCitizenships(List<Country> citizenships) {
		this.citizenships = citizenships;
	}

	public long getId() {
		return id;
	}
	
	public Country getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(Country birthPlace) {
		this.birthPlace = birthPlace;
	}

	public List<Country> getPerson_citizenships() {
		return citizenships;
	}

	public void setPerson_citizenships(List<Country> person_citizenships) {
		this.citizenships = person_citizenships;
	}

	public void addPerson_citizenship(Country country) {
		List<Country> country_list = getPerson_citizenships();
		if(country_list != null)
		{
			country_list = new ArrayList<Country>();
		}
		country_list.add(country);
		setPerson_citizenships(country_list);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getFamilyStatus() {
		return familyStatus;
	}

	public void setFamilyStatus(String familyStatus) {
		this.familyStatus = familyStatus;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEdducation() {
		return edducation;
	}

	public void setEdducation(String edducation) {
		this.edducation = edducation;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

//	public FamilyMember getFamilyMember() {
//		return familyMember;
//	}
//
//	public void setFamilyMember(FamilyMember familyMember) {
//		this.familyMember = familyMember;
//	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<PersonCustomData> getPersonCustomDatas() {
		return personCustomDatas;
	}

	public void setPersonCustomDatas(List<PersonCustomData> personCustomDatas) {
		this.personCustomDatas = personCustomDatas;
	}

	public List<PersonDocuments> getPersonDocuments() {
		return programs;
	}

	public void setPersonDocuments(List<PersonDocuments> personDocuments) {
		this.programs = personDocuments;
	}

	public List<Way> getWays() {
		return programWays;
	}

	public void setWays(List<Way> ways) {
		this.programWays = ways;
	}

}
