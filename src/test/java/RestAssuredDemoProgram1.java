import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;

public class RestAssuredDemoProgram1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().header("Content-Type", "application/json").body(Payload.AddPlace())
				.queryParam("key", "qaclick123").when().post("maps/api/place/add/json").then().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).body("status", equalTo("OK"))
				.header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

		JsonPath js = new JsonPath(response);

		System.out.println("place id is " + js.getString("place_id"));

		String place_id = js.getString("place_id");

		System.out.println(place_id);

		given().log().all().body("").header("Content-Type", "application/json").queryParam("key", "qaclick123")
				.body("{\r\n" + "\"place_id\":\"" + place_id + "\",\r\n" + "\"address\":\"80 Summer walk, USA\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
				.when().put("/maps/api/place/update/json").then().assertThat().statusCode(200).log().all()
				.body("msg", equalTo("Address successfully updated"));

		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id).when()
				.get("/maps/api/place/get/json").then().assertThat().statusCode(200).extract().response().asString();

		// JsonPath getJS = new JsonPath(getResponse);
		
		JsonPath getJS = ReusableMethods.rawToJson(getResponse);

		System.out.println(getJS.getString("address"));

		Assert.assertEquals("80 Summer walk, USA", "80 Summer walk, USA");

	}

}
