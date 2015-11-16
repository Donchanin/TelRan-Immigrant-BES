package tel_ran.immigrants.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Embassy {
	
	@Id
	@GeneratedValue
	@Column(name = "EMBASSY_ID")
	private int id;
	
	@Column(name = "EMBASSY_PHONE")
	private String phone;
	
	@Column(name = "EMBASSY_LINK")
	private String link;	
	
	@OneToOne
	@JoinColumn(name="ADDRESS_ID")
    private Address address;
	
	@ManyToOne	
	private Country country;

	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Address getEmbassy_address() {
		return address;
	}

	public void setEmbassy_address(Address embassy_address) {
		this.address = embassy_address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
