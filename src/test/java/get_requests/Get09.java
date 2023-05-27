package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerOkuAppBaseUrl {
     /*
      Given
          https://restful-booker.herokuapp.com/booking/798
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
            "firstname": "John",
            "lastname": "Smith",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "Breakfast"
            }
   */

    @Test
    public void get09(){
        //Set the url
        spec.pathParams("first","booking","second",1087);

        //Set the expected data
        Map<String, String> bookingdatesMap = new HashMap<>();//Önce inner map oluşturulur
        bookingdatesMap.put("checkin","2018-01-01");
        bookingdatesMap.put("checkout","2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname","John");
        expectedData.put("lastname","Smith");
        expectedData.put("totalprice",111);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdatesMap);
        expectedData.put("additionalneeds","Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"), ((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"), ((Map)actualData.get("bookingdates")).get("checkout"));



    }


}
