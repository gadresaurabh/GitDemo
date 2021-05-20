package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJsonProgram {

	@Test(dataProvider="loadEmp")
	public void DynamicJson(String salary, String age) {
		
		 
		
		RestAssured.baseURI = "http://dummy.restapiexample.com";

		String postPayload = given().header("Content-Type", "application/json").body(Payload.AddBook(salary, age))
				.when().post("/api/v1/create").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		JsonPath js = ReusableMethods.rawToJson(postPayload);

		System.out.println(js.getInt("data.id"));
	}

	@DataProvider(name="loadEmp")
	public Object[][] loadData() {
		// TODO Auto-generated method stub
	return new Object [][] {{"1","2"},{"3","4"},{"5","6"}};
	

	}

}
