package by.htp.library.action.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class NoDataReply {

	public String noDataReceived(String nameImpl, String nameDao) {		
		
		Map<String, List<String>> mapJsonDataRecived = new HashMap<>();
		List<String> listDataRecived = new ArrayList<>();
		
		listDataRecived.add(nameImpl);
		listDataRecived.add(nameDao);		
		mapJsonDataRecived.put("noDataReceived", listDataRecived);
		
		String json = new Gson().toJson(mapJsonDataRecived);
		
		return json;
		
	}
	
}
