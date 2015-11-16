package tel_ran.immigrants.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	private long id;
	
	@Column(name = "ADDRESS_STREET")
	private String street;
	
	@Column(name = "ADDRESS_BLD")
	private String bld;
	
	@Column(name = "ADDRESS_APPR")
	private int appr;
	
	@Column(name = "ADDRESS_CITY")
	private String city;
	
	@Column(name = "ADDRESS_REGION")
	private String region;
	
	@ManyToOne
	@JoinColumn(name="PERSDATA_ID", updatable=true)
	private PersonData personData;
	
	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")  
	private Country country;
	  		
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getBld() {
		return bld;
	}
	public void setBld(String bld) {
		this.bld = bld;
	}
	public int getAppr() {
		return appr;
	}
	public void setAppr(int appr) {
		this.appr = appr;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public long getId() {
		return id;
	}

	public PersonData getPersonData() {
		return personData;
	}
	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country addres_country) {
		this.country = addres_country;
	}
//	public Embassy getEmbassy() {
//		return embassy;
//	}
//	public void setEmbassy(Embassy embassy) {
//		this.embassy = embassy;
//	}
//	

}
