package Helper;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class tempAPI
{
    RequestSpecification httpRequest;
    Response response;
    String url = "http://localhost:3000/";

    @Test
    public void testingAPI()
    {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given().auth().preemptive().basic("admin", "admin");
        response = httpRequest.get("/api/teams/19/members");
        response.prettyPrint();


    }
}
