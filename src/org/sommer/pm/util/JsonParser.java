package org.sommer.pm.util;

import java.math.BigInteger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.sommer.pm.data.domain.Snapshot;

public class JsonParser {

	public static Snapshot parseFilesString(String filesStr) {
		
		try {
			Snapshot returnVal = new Snapshot();
	
			final JSONObject jsonFiles = new JSONObject(filesStr);
			final JSONArray innerJson = (JSONArray) jsonFiles.get("files");
			
			returnVal.setUrl((String)((JSONObject) innerJson.get(0)).get("url"));
			returnVal.setLastModified(
					BigInteger.valueOf((Long)
							((JSONObject) innerJson.get(0)).get("lastModified")));
			
			return returnVal;
			
		} catch (JSONException jse) {
			System.err.println(jse);
			
			return null;
		}
	}
}
