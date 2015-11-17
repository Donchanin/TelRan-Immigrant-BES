package tel_ran.immigrants.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;




import tel_ran.immigrants.entities.Address;
import tel_ran.immigrants.entities.Country;
import tel_ran.immigrants.entities.Embassy;
import tel_ran.immigrants.entities.PersonData;



public class CountriesData {
	
	@PersistenceContext(unitName="springHibernate")
	EntityManager em;
	
	
	
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

}
