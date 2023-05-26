package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Odev2 extends ReqresBaseUrl {

 /*
 task 2
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
 @Test
 public void odev02() {
     //set th url
     spec.pathParam("first","23");

     //Send the request and get the response
     Response response=given(spec).get("{first}"); //accept(ContentType.JSON) BaseUrl clasında ekli zaten
     response.prettyPrint();

     //Do Assertion

     response.then().
             statusCode(404).
             contentType(ContentType.JSON).
             statusLine("HTTP/1.1 404 Not Found");
     //Server is "cloudflare"
     String server=response.header("Server");
     Assert.assertEquals("cloudflare",server);
     //Response body should be empty
     assertFalse(response.asString().contains("id"));

 }
}
