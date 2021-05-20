package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
	public static JsonPath rawToJson(String getResponse)
	{
		JsonPath getJS = new JsonPath(getResponse);
		return getJS;
	}

	

}
