package tel_ran.immigrnats.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import tel_ran.immigrants.entities.Country;
import tel_ran.immigrants.repositories.CountriesData;
import tel_ran.immigrants.utils.SpringApplicationContext;

public class CountryService extends AbstractService {

	CountriesData countryBase;
	private final static String KEY_NAME = "name";
	private final static String KEY_LINK = "link";
	private final static String KEY_ID = "id";
	
	public CountryService() {
		countryBase = (CountriesData) SpringApplicationContext.getBean("countryBase");
	}

	public String getList() {
		List<Country> listFromDb = countryBase.getCountryList();
		JsonArray array = new JsonArray();
		for(Country c : listFromDb) {
			JsonObject jsn = new JsonObject();			
			jsn.addProperty(KEY_ID, c.getId());
			jsn.addProperty(KEY_NAME, c.getName());
			jsn.addProperty(KEY_LINK, c.getLink());
			array.add(jsn);
		}		
		return array.toString();
	}
	
}
