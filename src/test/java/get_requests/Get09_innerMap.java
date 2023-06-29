package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09_innerMap extends HerOkuAppBaseUrl {
     /*
      Given
          https://restful-booker.herokuapp.com/booking/389
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
        spec.pathParams("first","booking","second",389);

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

        //Value olarak "Object" data tipi dönen değerleri Casting yaparak asıl data türüne çeviriyoruz ve methodlara bu yöntem ile ulaşabiliyoruz.
        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));

        /*ChatGBT
        String  json="{\n" +
                "            \"firstname\": \"John\",\n" +
                "            \"lastname\": \"Smith\",\n" +
                "            \"totalprice\": 111,\n" +
                "            \"depositpaid\": true,\n" +
                "            \"bookingdates\": {\n" +
                "                \"checkin\": \"2018-01-01\",\n" +
                "                \"checkout\": \"2019-01-01\"\n" +
                "            },\n" +
                "            \"additionalneeds\": \"Breakfast\"\n" +
                "            }";

        HashMap<String, Object> hashMap = new Gson().fromJson(json, HashMap.class);

*/
    }
    @Test  //dinamik yöntem -- HerOkuAppTestData methodları ile
    public void get09b(){
        //Set the url
        spec.pathParams("first","booking","second",389);

        //Set the expected data
        Map<String, String> bookingdatesMap = new HerOkuAppTestData().bookingdatesMapMethod("2018-01-01","2019-01-01");

        Map<String, Object> expectedData = new HerOkuAppTestData().expectedDataMapMethod("John","Smith",111,true,bookingdatesMap,"Breakfast");
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

        //Value olarak "Object" data tipi dönen değerleri Casting yaparak asıl data türüne çeviriyoruz ve methodlara bu yöntem ile ulaşabiliyoruz.
        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));

        assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));}


}
