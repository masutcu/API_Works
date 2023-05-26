package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Odev3 extends ReqresBaseUrl {
      /*
    task3
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"

           {
    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
    */
      @Test
      public void odev03() {
          //set th url
          spec.pathParams("first","2");

          //Send the request and get the response
          Response response=given(spec).get("{first}"); //accept(ContentType.JSON) BaseUrl clasında ekli zaten
          response.prettyPrint();

          String body=response.asString();
          System.out.println(body);

          //Do Assertion
          response.then().
                  statusCode(200).
                  contentType(ContentType.JSON);
          response.then().
                  body("data.email",equalTo("janet.weaver@reqres.in"),
                          "data.first_name",equalTo("Janet"),
                          "data.last_name",equalTo("Weaver"),
                          "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));





        //diğer yol hard
        /*    Assert.assertTrue(body.contains("Janet"));
          Assert.assertTrue(body.contains("Weaver"));
          Assert.assertTrue(body.contains("janet.weaver@reqres.in"));
          Assert.assertTrue(body.contains("To keep ReqRes free, contributions towards server costs are appreciated!"));


   */


      }
}
