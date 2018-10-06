package learn.java.v8.lambda;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Ignore;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RelationalToJson {
	public static final String VEH_ID = "veh.id";
	public static final String VEH_NAME = "veh.name";
	public static final String VEH_TYPE = "veh.type";
	public static final String VEH_FM_ID = "veh.fm.id";
	public static final String VEH_FM_NAME = "veh.fm.name";
	public static final String VEH_FM_SD = "veh.fm.sd";
	//public static final String VEH_FM = "veh.fm.name";
	
	
	@Test
	//@Ignore
	public void testJava8Way() {
		List<Map<String, String>> resultSet = createData();
		//Map<String, List<Map<String, String>>> listVeh = list.stream().collect(Collectors.groupingBy(row -> row.get(VEH_ID)));
		if(resultSet.size() <= 0)
			return;
		List<Map<String, Set<String>>> dataForJson = new ArrayList<>();
		Set<String> keys = resultSet.get(0).keySet();
		keys.forEach((key) -> {
			System.out.println(key);
			//if(key.endsWith(".id")){
				//get unique values for .id keys
				Map<String, Set<String>> listByKey = 
						resultSet.stream().collect(Collectors.groupingBy(rec -> getGroupingByKey(rec,key),
						Collectors.mapping(rec -> rec.get(key), Collectors.toSet())));
				//System.out.println(listByKey);
				dataForJson.add(listByKey);
			//}
			
			
		
		});
		
		System.out.println(dataForJson);
		Map<String, Object> jsonMap = getJsonMap(dataForJson);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(jsonMap);
		System.out.println(json);
		
	}
	
	@Test
	@Ignore
	public void testDirectReadingData() {
		List<Map<String, String>> resultSet = createData();
		if(resultSet.size() <= 0)
			return;
		Map<String, Object> jsonMap = new HashMap<>();
		resultSet.forEach(record -> {
			record.keySet().forEach(key->{
				String[] keyParts = key.split(".");
				for(String keyPart: keyParts){
					String value = record.get(keyPart);
					
				}
			});
		});
		
	}
	
	private Map<String, Object> getJsonMap(List<Map<String, Set<String>>> dataForJson) {
		// TODO Auto-generated method stub
		Map<String, Object> jsonMap = getJsonMapForIds(dataForJson);
		dataForJson.forEach(row ->{
			row.forEach((mapKey, mapValue)->{
			if(mapKey.endsWith(".id"))
				return;
			String idsOnly = mapKey.substring(0, mapKey.lastIndexOf("-"));
			String[] keys = mapKey.substring(mapKey.lastIndexOf("-")+1).split("\\.");
			System.out.println("mapKey - "+mapKey);
			StringBuilder keysOnly = new StringBuilder();
			Object valueTrace = jsonMap;
			String parentKey = null;
			for(int i=0;i<keys.length;i++){
				parentKey = keysOnly==null?"":keysOnly.toString();
				keysOnly.append((keysOnly.length()==0?"":".")+keys[i]);
				System.out.println(idsOnly);
				System.out.println(keysOnly);
				if(valueTrace instanceof Map){
					Object valObject = ((Map<String, Object>)valueTrace).get(keysOnly.toString());
					if(valObject==null){
						((Map<String, Object>)valueTrace).put(keysOnly.toString(),mapValue.toArray()[0]);
					}else{
						valueTrace = valObject;
					}
				}else if(valueTrace instanceof List){
					Object valObject = null;
					for(Map<String, Object> rec: (List<Map<String, Object>>)valueTrace){
						if(idsOnly.equals(rec.get("id"))){
							valObject = rec.get(keysOnly.toString());
							if(valObject == null){
								rec.put(keysOnly.toString(),mapValue.toArray()[0]);
							}
							continue;
						}
					}
					
					if(valObject == null){
						System.out.println("Error");;
					}else{
						valueTrace = valObject;
					}
				}
				
				
	
			}
			});
		});
		return jsonMap;
	}

	private Map<String, Object> getJsonMapForIds(List<Map<String, Set<String>>> dataForJson) {
		Map<String, Object> jsonMap = new HashMap<>();
		dataForJson.forEach(row ->{
			row.keySet().forEach(mapKey->{
				if(mapKey.endsWith(".id")){
					String[] ids = mapKey.substring(0, mapKey.lastIndexOf("-")).split("-");
					String[] keys = mapKey.substring(mapKey.lastIndexOf("-")+1).split("\\.");
					System.out.println("mapKey - "+mapKey);
					StringBuilder idsOnly = new StringBuilder();
					StringBuilder keysOnly = new StringBuilder();
					Map<String, Object> mapTrace = jsonMap;
					for(int i=0;i<ids.length;i++){
						//System.out.println("id - "+ids[i]);
						//System.out.println("key - "+keys[i]);
						idsOnly.append((idsOnly.length()==0?"":"-")+ids[i]);
						keysOnly.append((keysOnly.length()==0?"":".")+keys[i]);
						System.out.println(idsOnly);
						System.out.println(keysOnly);
						Object valObject = mapTrace.get(keysOnly.toString());
						if(valObject==null){
							Map<String, Object> values = new HashMap<>();
							mapTrace.put(keysOnly.toString(), values );
							System.out.println(String.format("before jsonMap - %s", jsonMap));
							values.put("id", idsOnly.toString());
							System.out.println(String.format("afterjsonMap - %s", jsonMap));
							mapTrace = values;
						}else if(valObject instanceof Map && ((Map<String, Object>) valObject).get("id")!=null && !(idsOnly.toString().equals(((Map<String, Object>) valObject).get("id").toString()))){
							Map<String, Object> mapElement = new HashMap<>(); 
							List<Map<String, Object>> mapList = new ArrayList<>();
							mapList.add((Map<String, Object>) valObject);
							mapList.add(mapElement);
							mapTrace.put(keysOnly.toString(), mapList);
							mapElement.put("id", idsOnly.toString());
							mapTrace = mapElement;
						}else if(valObject instanceof List){
							mapTrace = new HashMap<>(); 
							List<Map<String, Object>> mapList = (List<Map<String, Object>>) valObject;
							mapList.add(mapTrace);
						}
						else{
							mapTrace = (Map<String, Object>) valObject;
						}
			
					}
				}
			});
			
		});
		return jsonMap;
	}

	private String getGroupingByKey(Map<String, String> rec, String key){
		String mapKey = new String(key);
		StringBuilder groupByKey = new StringBuilder(key);
		if(mapKey.endsWith(".id")){
			groupByKey.insert(0,rec.get(mapKey)+"-");
			mapKey = mapKey.substring(0, mapKey.lastIndexOf("."));
		}
		while(mapKey.length()!=0){
			int lastIndexOfDot = mapKey.lastIndexOf(".");
			if(lastIndexOfDot == -1)
				break;
			mapKey = mapKey.substring(0, lastIndexOfDot);
			groupByKey.insert(0,rec.get(mapKey+".id")+(groupByKey.length()==0?"":"-"));
		}
		
		return groupByKey.toString();
	}
	
	
	private List<Map<String, String>> createData(){
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		Map<String, String> row = new HashMap<String, String>();
		row.put(VEH_ID, "101");
		row.put(VEH_NAME, "Global Fund");
		row.put(VEH_TYPE, "Fund");
		row.put(VEH_FM_ID, "201");
		row.put(VEH_FM_NAME, "Amandeep");
		row.put(VEH_FM_SD, "26 Oct 2016");
		data.add(row);
		row = new HashMap<String, String>();
		row.put(VEH_ID, "101");
		row.put(VEH_NAME, "Global Fund");
		row.put(VEH_TYPE, "Fund");
		row.put(VEH_FM_ID, "202");
		row.put(VEH_FM_NAME, "Amit");
		row.put(VEH_FM_SD, "27 Nov 2016");
		data.add(row);
		return data;
	}

}
