package tel_ran.immigrants.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WayDocuments {
	
	@Id
	@GeneratedValue
	@Column(name = "WAY_DOCUMENTS_ID")
	private long id;
	
	private boolean isReady;
	
	@ManyToOne
	@JoinColumn(name="WAY_ID")
	private Way way;
	
   @ManyToOne
   @JoinColumn(name="PERSON_DOCUMENT_ID")
   private PersonDocuments personDocument;
   
   @ManyToOne
   @JoinColumn(name="DOCUMENT_ID")
   private Document requiredDocument;

public long getId() {
	return id;
}



public Document getRequiredDocument() {
	return requiredDocument;
}



public void setRequiredDocument(Document requiredDocument) {
	this.requiredDocument = requiredDocument;
}



public PersonDocuments getPersonDocument() {
	return personDocument;
}



public void setPersonDocument(PersonDocuments personDocument) {
	this.personDocument = personDocument;
}



public boolean isReady() {
	return isReady;
}

public void setReady(boolean isReady) {
	this.isReady = isReady;
}

public Way getWay() {
	return way;
}

public void setWay(Way way) {
	this.way = way;
}

public PersonDocuments getPersondocument() {
	return personDocument;
}

public void setPersondocument(PersonDocuments persondocument) {
	this.personDocument = persondocument;
}


public Document getDocument() {
	return requiredDocument;
}


public void setDocument(Document document) {
	this.requiredDocument = document;
}

}
