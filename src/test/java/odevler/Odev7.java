package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import pojos.ReqresPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Odev7 extends ReqresBaseUrl {
    //2)

  /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void odev7() {
        //set the url
        spec.pathParam("first","users");
        //set the expected data
        ReqresPojo expectedData=new ReqresPojo("morpheus","leader");
        System.out.println("expected data :"+ expectedData);
        //send the request get the response
        Response response=  given(spec).body(expectedData).post("{first}");
        response.prettyPrint();
        //do assertion
        ReqresPojo actualData=response.as(ReqresPojo.class);
        System.out.println("actual data: "+actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());

        Map<?, ?> actualDatas = response.as(HashMap.class);
        System.out.println(actualDatas);
        assertTrue(actualDatas.containsKey("createdAt"));
        assertTrue(actualDatas.containsKey("id"));

    }
    //3)

/*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.
*/

}
