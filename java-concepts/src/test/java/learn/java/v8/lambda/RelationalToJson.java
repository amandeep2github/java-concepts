package learn.java.v8.lambda;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.google.gson.Gson;

public class RelationalToJson {
	public static final String VEH_ID = "veh.id";
	public static final String VEH_NAME = "veh.name";
	public static final String VEH_TYPE = "veh.type";
	public static final String VEH_FM_ID = "veh.fm.id";
	public static final String VEH_FM_NAME = "veh.fm.name";
	public static final String VEH_FM_SD = "veh.fm.sd";
	//public static final String VEH_FM = "veh.fm.name";
	
	
	@Test
	public void test() {
		List<Map<String, String>> list = createData();
		//list.stream().collect(Collectors.groupingBy(row -> row[VEH_ID]));
		//Gson gson = new Gson(); 
		//String json = gson.toJson(createData());
		//System.out.println(json);
		
	}
	
	private List<Map<String, String>> createData(){
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		Map<String, String> row = new HashMap<String, String>();
		row.put(VEH_ID, "101");
		row.put(VEH_NAME, "Global Fund");
		row.put(VEH_TYPE, "Fund");
		row.put(VEH_FM_ID, "201");
		row.put(VEH_FM_NAME, "Amandeep");
		row.put(VEH_FM_SD, "27 Oct 2016");
		data.add(row);
		row = new HashMap<String, String>();
		row.put(VEH_ID, "102");
		row.put(VEH_NAME, "Global Fund");
		row.put(VEH_TYPE, "Fund");
		row.put(VEH_FM_ID, "202");
		row.put(VEH_FM_NAME, "Amit");
		row.put(VEH_FM_SD, "26 Nov 2016");
		data.add(row);
		return data;
	}

}
