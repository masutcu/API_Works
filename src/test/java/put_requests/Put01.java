package put_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Put01 extends JsonPlaceHolderBaseUrl {
     /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
I send PUT Request to the Url
 Then
      Status code is 200
      And response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                   "id": 198
                  }
 */


    @Test
    public void put01() {
        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expeced data
        Map<String,Object> expectedData=new JsonPlaceHolderTestData().expectedDataMapMethod(21,"Wash the dishes",false);

        System.out.println("expected data : "+expectedData);

        //send the request get the response
       Response response= given(spec).body(expectedData).put("{first}/{second}");
       response.prettyPrint();

       //do assertion
        Map<String,Object> actualData=response.as(HashMap.class); //de serialization json to java
        System.out.println("actual data : "+actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));



    }
}
