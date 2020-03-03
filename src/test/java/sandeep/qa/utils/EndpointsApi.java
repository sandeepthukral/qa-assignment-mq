/**
 * This class has methods that use the Endpoint calls to perform actions outside the UI.
 * These could be data setup or cleanup.
 * These could be used to improve test performance and reliability
 */
package sandeep.qa.utils;

import io.restassured.response.Response;
import sandeep.qa.steps.Context;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class EndpointsApi {

    private Context context;

    public EndpointsApi(Context context){
        this.context = context;
    }

    public void deleteEmployee(){
        String path = "https://cafetownsend-angular-rails.herokuapp.com/employees/" + context.employeeId;

        given().header("X-CSRF-TOKEN", "" + context.csrfToken)
                .header("Cookie", context.cookieName + "=" + context.cookieValue)
                .contentType("application/json")
                .accept("application/json")
                .log().headers().log().uri()
                .delete(path)
                .then().log().body()
                .statusCode(anyOf(is(204), is(404)));
    }

    public String createEmployee(String firstName, String lastName, String startDate, String email) {

        String path = "https://cafetownsend-angular-rails.herokuapp.com/employees";

        String json = "{\"employee\":{\"first_name\":\"" + firstName
                        + "\",\"last_name\":\"" +  lastName +
                        "\",\"start_date\":\"" + startDate +
                        "\",\"email\":\"" + email + "\"}}";

        System.out.println("Creating user " + firstName + " " + lastName);

        Response response = given()
            .header("X-CSRF-TOKEN", "" + context.csrfToken)
            .header("Cookie", context.cookieName + "=" + context.cookieValue)
            .contentType("application/json")
            .accept("application/json")
            .body(json)
            .log().headers().log().body()
            .post(path)
            .then().statusCode(200)
            .log().body()
            .extract().response();

        int employeeId = response.path("id");
        return Integer.toString(employeeId);
    }
}