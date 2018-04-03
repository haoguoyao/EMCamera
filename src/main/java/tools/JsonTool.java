package tools;

import java.util.List;
import java.util.Set;

import org.json.JSONArray;

public class JsonTool {
	public static JSONArray toJsonArray(List list) {
		JSONArray jsonArray = new JSONArray(list);
		return jsonArray;
	}
	public JSONArray toJsonArray(Set set) {
		JSONArray jsonArray = new JSONArray(set);
		return jsonArray;
	}

}
