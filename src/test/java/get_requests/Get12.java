package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.junit.Assert.assertEquals;

public class Get12 extends GoRestBaseUrl {

    /*
    Given
        https://gorest.co.in/public/v1/users/2587
    When
        User send GET Request to the URL
    Then
        Status Code should be 200
    And
        Response body should be like
      {
    "meta": null,
    "data": {
        "id": 2587,
        "name": "Ganapati Prajapat",
        "email": "prajapat_ganapati@okeefe.org",
        "gender": "female",
        "status": "active"
    }
}

*/

    @Test
    public void get12() {
        //set the url
        spec.pathParams("first","users","second",2587);
        //set the expected data
        GoRestDataPojo goRestDataPojo=new GoRestDataPojo("Ganapati Prajapat","prajapat_ganapati@okeefe.org","female","active");
        GoRestPojo expectedData=new GoRestPojo(null,goRestDataPojo);
        System.out.println("expected data : "+expectedData);

        //send the request get the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();
        //do assertion
        GoRestPojo actualData=response.as(GoRestPojo.class);
        System.out.println("actual data : "+actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        //assertEquals(expectedData.getData().getName(),actualData.getData().getName()); yerine 1 adım eksik
        assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());




    }
}
