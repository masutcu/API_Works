package delete_request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Delete01 extends JsonPlaceHolderBaseUrl {
     /*
     Given
         https://jsonplaceholder.typicode.com/todos/198
     When
   I send DELETE Request to the Url
Then
   Status code is 200
   And Response body is { }
  */

    @Test
    public void delete01() {
        //set the url
        spec.params("first","todos","second",198);
        //set the expectred data --boş bir map oluşturup karşılaştıralım
        Map<String ,String > expectedData=new HashMap<>();
        //send the request and get the response
        Response response=given().delete("{first}/{second}");
        response.prettyPrint();
        Map<String, String >  actualData= ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
        //1. yol
        Assert.assertEquals(expectedData, actualData);
        //2.yol
        Assert.assertTrue(actualData.isEmpty());
        //3.yol
        Assert.assertEquals(0,actualData.size());
    }
}
