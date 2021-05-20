import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonMockResponse {

	public static void main(String[] args) {

		JsonPath jsmockvalue = new JsonPath(Payload.getCoursePrice());

		/*
		 * { "dashboard": { "purchaseAmount": 910, "website": "rahulshettyacademy.com"
		 * }, "courses": [ { "title": "Selenium Python", "price": 50, "copies": 6 }, {
		 * "title": "Cypress", "price": 40, "copies": 4 }, { "title": "RPA", "price":
		 * 45, "copies": 10 } ] }
		 */

		// System.out.println(jsmockvalue);
		// print the number of courses in the array

		System.out.println(jsmockvalue.getInt("courses.size"));

		// print the title of the first course

		System.out.println(jsmockvalue.get("courses[0].title"));

		// print purchase amount

		int purchaseAmount = jsmockvalue.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// Print all course title and respective price

		for (int i = 0; i < jsmockvalue.getInt("courses.size"); i++) {
			System.out.println(jsmockvalue.get("courses[" + i + "].title"));
			System.out.println(jsmockvalue.getInt("courses[" + i + "].price"));
		}

		System.out.println("course RPA -> Copy ");

		for (int j = 0; j < jsmockvalue.getInt("courses.size"); j++) {
			if (jsmockvalue.get("courses[" + j + "].title").equals("RPA")) {
				System.out.println("copies are " + jsmockvalue.getInt("courses[" + j + "].copies"));
				break;
			}

		}

	}

}
