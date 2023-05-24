package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {
        /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
          I send a GET request to the Url
       And
           Accept type is “application/json”
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           There should be 200 todos
       And
           "quis eius est sint explicabo" should be one of the todos title  == > todos başlıklarından en az biri olmalı
       And
           2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04() {
        //Set the url
      //  String url="https://jsonplaceholder.typicode.com/todos"; // =>tavsiye edilmez
             spec.pathParams("first","todos"); //spec: tekrarlı işlemlerin konulduğu RequestResponse

        //Set the expected data

        //Send the request and get the response
        Response response=given(spec).get("{first}"); //accept(ContentType.JSON) BaseUrl clasında ekli zaten
        response.prettyPrint();

        //Do Assertion

        response.then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id",hasSize(200)).
                body("title",hasItems("quis eius est sint explicabo")).
                body("userId",hasItems(2,7,9));

        //hasSize() ==> Eleman sayısını assert eder
        //hasItem() ==> contains() methodu gibi bir objenin içerilip içerilmediğini assert eder --> import static org.hamcrest.CoreMatchers.hasItems;
        //hasItems() ==> containsAll() methodu gibi birden fazla objenin içerilip içerilmediğini assert eder
    }
}
