package util;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {
	public static String getJsonObjectValue(HttpServletRequest request) {

		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (IOException e) { 
			e.printStackTrace(); 
		}
		String method = null;
		try {
			JSONObject jo =  HTTP.toJSONObject(jb.toString());
			method = jo.getString("Method");
		} catch (JSONException e) {
			e.printStackTrace(); 
		}
		return method;
	}
}
