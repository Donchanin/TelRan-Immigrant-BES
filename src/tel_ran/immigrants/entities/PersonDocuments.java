package tel_ran.immigrants.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonDocuments {
	
  @Id
  @GeneratedValue
  private long id;
  private String documentType;
  private String linkToImage;
  private String language;
  
  @Column(length=2000)
  private String translations;
  private boolean isTemporary;
  
  @Temporal(TemporalType.DATE)
  private Date expirationDate;
  
  @ManyToOne
  @JoinColumn(name = "PERSONDATA_ID", nullable = false)
  private PersonData personData;
  
  @OneToMany (mappedBy = "personDocument")
  private List<WayDocuments> waydocuments;
    
  
public String getDocumentType() {
	return documentType;
}
public void setDocumentType(String documentType) {
	this.documentType = documentType;
}
public String getLinkToImage() {
	return linkToImage;
}
public void setLinkToImage(String linkToImage) {
	this.linkToImage = linkToImage;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getTranslations() {
	return translations;
}
public void setTranslations(String translations) {
	this.translations = translations;
}
public boolean isTemporary() {
	return isTemporary;
}
public void setTemporary(boolean isTemporary) {
	this.isTemporary = isTemporary;
}
public Date getExpirationDate() {
	return expirationDate;
}
public void setExpirationDate(Date expirationDate) {
	this.expirationDate = expirationDate;
}
public PersonData getPersonData() {
	return personData;
}
public void setPersonData(PersonData personData) {
	this.personData = personData;
}
public long getId() {
	return id;
}
public List<WayDocuments> getWaydocuments() {
	return waydocuments;
}
public void setWaydocuments(List<WayDocuments> waydocuments) {
	this.waydocuments = waydocuments;
}

}
