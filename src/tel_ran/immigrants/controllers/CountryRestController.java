package tel_ran.immigrants.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tel_ran.immigrants.utils.SpringApplicationContext;
import tel_ran.immigrnats.services.CountryService;




@Controller
@RequestMapping({"/country"})
public class CountryRestController {

	
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
		CountryService service = new CountryService();
		result = service.getList();
		
		return result;
	}
	
}
