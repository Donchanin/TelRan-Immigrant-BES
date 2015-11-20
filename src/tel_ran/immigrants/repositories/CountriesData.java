package tel_ran.immigrants.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;











import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import tel_ran.immigrants.constants.JsonKeys;
import tel_ran.immigrants.entities.Address;
import tel_ran.immigrants.entities.Country;
import tel_ran.immigrants.entities.Embassy;
import tel_ran.immigrants.entities.PersonData;



public class CountriesData {
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	public List<Country> getCountryList(){
		List<Country> result = em.createQuery("SELECT c FROM Country c").getResultList();
		return result;		
	}
	
	public boolean isCountryDataNotEmplty() {
		
		String query = "SELECT c FROM Country c";
		
		if(em == null)
			System.out.println("NULL");
		
		List<Country> countries = em.createQuery(query).getResultList();
		if(countries == null || countries.isEmpty() || countries.size()<1) {
			return false;
		}		
		return true;
		
	}
	
	
	@Transactional(readOnly=false)
	public int addContry(String name, String link) {
		int result = -1;
		Country ec = new Country();
		ec.setLink(link);
		ec.setName(name);
		try {
			em.persist(ec);
			result = ec.getId();
		} catch (Exception e) {
			Query query = em.createQuery("SELECT c FROM Country c WHERE c.name LIKE :parName");
			query.setParameter("parName", name);
			Country res = (Country) query.getSingleResult();
			result = res.getId();
		}
		return result;
	}
	
	@Transactional(readOnly=false)
	public int addEmbassy(int countryId, String phone, String link) {
		int result = -1;
		
		Country country = em.find(Country.class, countryId);
		if(country!=null) {
			Embassy embassy = new Embassy();	
			embassy.setPhone(phone);		
			embassy.setLink(link);
			embassy.setCountry(country);		
			em.persist(embassy);
			result = embassy.getId();
		}
		return result;		
	}
	
	@Transactional(readOnly=false)
	public void addAddress(long personDataId, int embassyId, int countryId, String street, String bld, String city, String region, int aprt) {
				
		Country ec = em.find(Country.class, countryId);
		
		Address address = new Address();
		address.setAppr(aprt);
		address.setBld(bld);
		address.setCity(city);
		address.setCountry(ec);
		
		if(personDataId>=0) {
			PersonData epd = em.find(PersonData.class, personDataId);
			address.setPersonData(epd);
		}	
				
		address.setRegion(region);
		address.setStreet(street);		
		em.persist(address);
		
		if(embassyId>0) {
			Embassy emb = em.find(Embassy.class, embassyId);
			emb.setAddress(address);
			em.merge(emb);
		}
	}

	public JsonObject getCountryFullInfo(int idCountry) {
		Country c = em.find(Country.class, idCountry);
		if(c==null) return null;
		JsonObject jsn = new JsonObject();
		jsn.addProperty(JsonKeys.COUNTRY_ID, c.getId());
		jsn.addProperty(JsonKeys.COUNTRY_NAME, c.getName());
		jsn.addProperty(JsonKeys.COUNTRY_LINK, c.getLink());
		
		return jsn;
	}

	public JsonArray getEmbassiesList(int idCountry) {
		Country c = em.find(Country.class, idCountry);
		if(c==null) return null;
		List<Embassy> embList = c.getEmbassys();			
		JsonArray array = new JsonArray();
		for(Embassy e : embList) {
			array.add(getShortEmbassyInfo(e));
		}		
		return array;
	}
	
	public JsonObject getShortEmbassyInfo(Embassy e) {
		JsonObject jsn = new JsonObject();
		jsn.addProperty(JsonKeys.EMBASSY_ID, e.getId());
		Country cIn = e.getAddress().getCountry();
		jsn.addProperty(JsonKeys.EMBASSY_IN_COUNTRY, cIn.getId());
		jsn.addProperty(JsonKeys.EMBASSY_IN_COUNTRY_NANE, cIn.getName());
		return jsn;
	}
	
	public JsonObject getShortEmbassyInfo(int idEmbassy) {
		Embassy e = em.find(Embassy.class, idEmbassy);
		return getShortEmbassyInfo(e);
	}

	public String countryNameById(int countryId) {
		Country c = em.find(Country.class, countryId);
		if(c!=null) return c.getName();
		return null;
	}

	public JsonObject getFullEmbassyInfo(int idEmbassy) {
		Embassy e = em.find(Embassy.class, idEmbassy);
		JsonObject jsn = getShortEmbassyInfo(e);
		Country cFrom = e.getCountry();
		jsn.addProperty(JsonKeys.EMBASSY_FROM_COUNTRY_ID, cFrom.getId());
		
		return null;
	}

}
