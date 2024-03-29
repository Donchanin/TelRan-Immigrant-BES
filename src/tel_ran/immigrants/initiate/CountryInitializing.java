package tel_ran.immigrants.initiate;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;









import tel_ran.immigrants.repositories.CountriesData;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jdk.nashorn.internal.parser.JSONParser;


public class CountryInitializing {
	
	private List<Map<String, String>> dataFromFile;
	private final static String FILE_NAME = "country";
	private final static String KEY_NAME = "Name";
	private final static String KEY_LINK = "Link";
	
	public CountryInitializing(CountriesData db) {
		dataFromFile = new ArrayList();
		try {
			getDataFromFile();
			setDataToDb(db);
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setDataToDb(CountriesData db) {
		
		for(Map<String,String> mp : dataFromFile) {
			db.addContry(mp.get(KEY_NAME), mp.get(KEY_LINK));			
		}
		
	}

	private void getDataFromFile() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		
		JsonParser parser = new JsonParser();
		File f = null;
		try {
			f = new File(CountryInitializing.class.getResource("country").toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f.getAbsolutePath());
		JsonArray array = (JsonArray) parser.parse(new FileReader(f));
		
		for(int i = 0; i < array.size(); i++) {
			JsonObject jsn = (JsonObject) array.get(i);
			Map<String,String> map = new HashMap<String, String>();
			map.put(KEY_NAME, jsn.get(KEY_NAME).getAsString());
			map.put(KEY_LINK, jsn.get(KEY_LINK).getAsString());
			dataFromFile.add(map);
		}		
		
	}
	
	
	
	
	
}
