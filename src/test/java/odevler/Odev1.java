package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class Odev1 extends ReqresBaseUrl {
    /*
    task1
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void odev01() {
        //set th url
        spec.pathParam("first","3");

        //Send the request and get the response
        Response response=given(spec).get("{first}"); //accept(ContentType.JSON) BaseUrl clasında ekli zaten
        response.prettyPrint();

        //Do Assertion

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }

}
