package tel_ran.immigrants.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Document {
	
	@Id
	@GeneratedValue
	@Column(name = "DOCUMENT_ID")
	private long id;
	
	@Column(name = "DOCUMENT_TYPE")
	private String type;
	
	@Column(name = "DOCUMENT_IMAGE")
	private String image;//path to the image of the form(only for form)
	
	@ManyToOne
	@JoinColumn(name="REQUIREMENTS_ID", nullable=false)
	private Requirements requirements;
	
//    @OneToMany(mappedBy="document")
//    private List<WayDocuments> waydocuments;
	
	
	
	public long getId() {
		return id;
	}
	public Requirements getRequirements() {
		return requirements;
	}
	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//	public List<WayDocuments> getWaydocuments() {
//		return waydocuments;
//	}
//	public void setWaydocuments(List<WayDocuments> waydocuments) {
//		this.waydocuments = waydocuments;
//	}


}
