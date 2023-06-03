package put_requests.post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05_ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {
     /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
          }


       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test //en iyi yöntem pojo class ile objectMapper ın beraber kullanılmasıdır.
    public void post05pojo() {
        //set the url
        spec.pathParam("first","todos");
        //set the expected data
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
        Response response=given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //do assertion
        //burada Json to java  yapacak metod (readValue()) exception attığı için utils de
        JsonPlaceHolderPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());


    }
}
