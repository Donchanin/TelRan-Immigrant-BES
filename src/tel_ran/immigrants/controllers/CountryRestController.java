package tel_ran.immigrants.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tel_ran.immigrants.utils.SpringApplicationContext;
import tel_ran.immigrnats.services.CountryService;




@Controller
@RequestMapping({"/country"})
public class CountryRestController {
	
	@Autowired
	CountryService service;

	
	/**
	 * Return JSONArray with LIST of COUNTRY with fields:
	 * - name = name of country
	 * - link = link to wiki
	 * - id = id of country
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody 
	public String getListOfcountry() {
		String result = "{}";		
		result = service.getList();		
		return result;
	}
	
	/**
	 * Return JSON with info about Country by its ID
	 * Fields:
	 * - name = name of country
	 * - link = link to wiki	 
	 */
	@RequestMapping(value="/{idCountry}", method=RequestMethod.GET)
	@ResponseBody
	public String getInfoCountry(@PathVariable int idCountry) {
		String result = "{}";
		
		result = service.getInfo(idCountry);
		return result;
	}
	
	/**
	 * Return JSON ARRAY with list of Embassies by Country ID
	 * Fields: 
	 * - emb_in_country = ID of country where the embassy is (int)
	 * - emb_in_country_n = NAME of country where the embassy is (String)
	 * - emb_id = id of embassy 
	 */
	@RequestMapping(value="/embassies"+"/{idCountry}", method=RequestMethod.GET)
	@ResponseBody
	public String getListEmbassies(@PathVariable int idCountry) {
		String result = "[]";
		result = service.getListEmbassies(idCountry);		
		return result;
	}
	
	/**
	 * Create new Embassy
	 * Get Json with info about new Embassy.
	 * Field:
	 * - emb_from_country = ID of country-parent(int) REQUIRED!!!!
	 * - emb_in_country = ID of country where the embassy is (int) REQUIRED!!!!
	 * - emb_link = link to web-site (String)
	 * - emb_phone = number of phone (String)
	 * - street = address ob embassy. Street(String)
	 * - building (String)
	 * - appartament (int)
	 * - city (String)
	 * - region (String)
	 * 
	 * Return Json with id of new Embassy and id and name of country
	 * Field:
	 * - emb_id = id of embassy
	 * - emb_in_country = ID of country where the embassy is(int)
	 * - emb_in_country_n = NAME
	 * - emb_from_country = ID of country-parent (int)
	 * - emb_from_country_n = NAME
	 */
	@RequestMapping(value="/addEmbassy", method=RequestMethod.POST)
	@ResponseBody
	public String addEmbassy(@RequestBody String embassyInfo) {
		String result = "{}";
		if(embassyInfo!=null) {
			result = service.createEmbassy(embassyInfo);			
		}		
		return result;		
	}
	
	/**
	 * Get info about Embassy by its Id
	 * Return Json with fields :
	 * - emb_from_country = ID of country-parent(int)
	 * - emb_from_country_n = NAME
	 * - emb_in_country = ID of country where the embassy is (int)
	 * - emb_in_country_n = NAME
	 * - emb_link = link to web-site (String)
	 * - emb_phone = number of phone (String)
	 * - street = address ob embassy. Street(String)
	 * - building (String)
	 * - appartament (int)
	 * - city (String)
	 * - region (String)
	 */
	@RequestMapping(value="/embassy" + "/{idEmbassy}", method = RequestMethod.GET)
	@ResponseBody
	public String getEmbassyInfo(@PathVariable int idEmbassy) {
		String result = "{}";
		if(idEmbassy>=0) {
			result = service.getEmbassyInfo(idEmbassy);
		}
		return result;
	}
	
}
