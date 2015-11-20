package tel_ran.immigrnats.services;

import java.util.List;

import jdk.nashorn.internal.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import tel_ran.immigrants.constants.JsonKeys;
import tel_ran.immigrants.entities.Country;
import tel_ran.immigrants.repositories.CountriesData;
import tel_ran.immigrants.utils.SpringApplicationContext;

public class CountryService extends AbstractService {

	@Autowired
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

	public String getInfo(int idCountry) {
		
		return countryBase.getCountryFullInfo(idCountry).toString();		
	}

	public String getListEmbassies(int idCountry) {
		
		JsonArray arr = countryBase.getEmbassiesList(idCountry);
		if(arr!=null) return arr.toString();
		return null;
	}

	public String createEmbassy(String embassyInfo) {
		String result = "{}";
		JsonParser parser = new JsonParser();
		JsonObject jsn = (JsonObject)parser.parse(embassyInfo);
		if(jsn!=null) {
			int countryFromId = jsn.get(JsonKeys.EMBASSY_FROM_COUNTRY_ID).getAsInt();
			int countryInId = jsn.get(JsonKeys.EMBASSY_IN_COUNTRY).getAsInt();
			String link = "";
			JsonObject jsnLink = (JsonObject) jsn.get(JsonKeys.EMBASSY_LINK);
			if(jsnLink!=null) link = jsnLink.getAsString();
			String phone = "";
			JsonObject jsnPhone = (JsonObject) jsn.get(JsonKeys.EMBASSY_PHONE);
			if(jsnPhone!=null) phone = jsnPhone.getAsString();
			String street = "";
			JsonObject jsnStreet = (JsonObject) jsn.get(JsonKeys.ADDRESS_STREET);
			if(jsnStreet!=null) street = jsnStreet.getAsString();
			String city = "";
			JsonObject jsnCity = (JsonObject) jsn.get(JsonKeys.ADDRESS_CITY);
			if(jsnCity!=null) city = jsnCity.getAsString();
			String bld = "";
			JsonObject jsnBld = (JsonObject) jsn.get(JsonKeys.ADDRESS_BUILDING);
			if(jsnBld!=null) bld = jsnBld.getAsString();
			int aprt = -1;
			JsonObject jsnAprt = (JsonObject) jsn.get(JsonKeys.ADDRESS_APPARTAMENT);
			if(jsnAprt!=null) aprt = jsnAprt.getAsInt();
			String region = "";
			JsonObject jsnRegion = (JsonObject) jsn.get(JsonKeys.ADDRESS_REGION);
			if(jsnRegion!=null) region = jsnRegion.getAsString();
			
			int embId = countryBase.addEmbassy(countryFromId, phone, link);
			if(embId>=0) {
				countryBase.addAddress(-1L, embId, countryInId, street, bld, city,
						region, aprt);
			}
			
			
			JsonObject resultJsn = new JsonObject();
			resultJsn.addProperty(JsonKeys.EMBASSY_ID, embId);
			resultJsn.addProperty(JsonKeys.EMBASSY_IN_COUNTRY, countryInId);
			resultJsn.addProperty(JsonKeys.EMBASSY_IN_COUNTRY_NANE, 
					countryBase.countryNameById(countryInId));
			resultJsn.addProperty(JsonKeys.EMBASSY_FROM_COUNTRY_ID, countryFromId);
			resultJsn.addProperty(JsonKeys.EMBASSY_FROM_COUNTRY_NAME, 
					countryBase.countryNameById(countryFromId));
			result = resultJsn.toString();
			
		}	
		return result;
	}
	
	private String getShortEmbassyInfo(int embId) {
		String result = "{}";
				
		
		return result;
	}

	public String getEmbassyInfo(int idEmbassy) {
				
		return countryBase.getFullEmbassyInfo(idEmbassy).toString();
	}
	
}
