package tel_ran.immigrants.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import tel_ran.immigrants.constants.JsonKeys;

import com.google.gson.JsonObject;

@Entity
@Table(name = "country", uniqueConstraints = {
		@UniqueConstraint(columnNames = "COUNTRY_NAME")
})
public class Country {

	@Id
	@GeneratedValue
	@Column(name = "COUNTRY_ID")
	private int id;
	
	@Column(name = "COUNTRY_NAME")
	String name;
	
	@Column(name = "COUNTRY_LINK")
	String link;

//	@OneToMany(mappedBy="birthPlace")
//	private List<PersonData> personDatas;
	
//	@OneToMany(mappedBy="addres_country")
//	private List<Address> addresses;
	
	@OneToMany(mappedBy="country")
	private List<Embassy> embassys;
	
	@OneToMany(mappedBy="progr_country")
	private List<Program> programs;
	
//	@ManyToMany
//	@JoinTable(name = "country_persondata", joinColumns = { 
//			@JoinColumn(name = "COUNTRY_ID", nullable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "PERSONDATA_ID", nullable = false) })
//	private List<PersonData> country_citizens;

	public int getId() {
		return id;
	}

	
//	public List<PersonData> getPersonDatas() {
//		return personDatas;
//	}
//	public void setPersonDatas(List<PersonData> personDatas) {
//		this.personDatas = personDatas;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

//	public List<PersonData> getCountry_citizens() {
//		return country_citizens;
//	}
//
//	public void setCountry_citizens(List<PersonData> country_citizens) {
//		this.country_citizens = country_citizens;
//	}
	
//	public void addCountry_citizen(PersonData personData) {
//		List<PersonData> personData_list = getCountry_citizens();
//		if(personData_list.isEmpty())
//		{
//			personData_list = new ArrayList<PersonData>();
//		}
//		personData_list.add(personData);
//		setCountry_citizens(personData_list);
//	}

//	public List<Address> getAddresses() {
//		return addresses;
//	}

//	public void setAddresses(List<Address> addresses) {
//		this.addresses = addresses;
//	}

	public List<Embassy> getEmbassys() {
		return embassys;
	}

	public void setEmbassys(List<Embassy> embassys) {
		this.embassys = embassys;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	

}
