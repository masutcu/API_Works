package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07_GroovyLg extends JsonPlaceHolderBaseUrl {
      /*
 Given
         https://jsonplaceholder.typicode.com/todos
 When
     I send GET Request to the URL == > URL'e Get Request gonderin
 Then
     1)Status code is 200 == > Status kodu 200 olmali
     2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
       Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin
     3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin
       Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin
     4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
       Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
       basliginin "delectus aut autem" icerdigini dogrulayin
*/
    @Test
    public void get07(){
        //set the url
        spec.pathParam("first","todos");
        /*
        [
    {
        "userId": 1,
        "id": 1,
        "title": "delectus aut autem",
        "completed": false
    },
    {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    },
    {
        "userId": 1,
        "id": 3,
        "title": "fugiat veniam minus",
        "completed": false
    },
    uzun bir list dönüyor. köşeli parantez varsa list
         */

        //set the expected data
        //send the request get the response
        Response response=given(spec).get("{first}");
        response.prettyPrint();

        //do assertion
        Assert.assertEquals(200,response.getStatusCode());
        //Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
        JsonPath jsonPath=response.jsonPath();
        List<Object> list=jsonPath.getList("findAll{it.id>190}.id");//Groovy Language -->java temelli programlama dili
        System.out.println("list : "+list);


        //Assert that there are 10 ids greater than 190
        assertEquals(10, list.size());

        //Print all userIds whose ids are less than 5 on the console
        List<Integer> userIdList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);

        //Assert that the number of userIds whose ids are less than 5 is 4
        assertEquals(4, userIdList.size());

        //Print all titles whose ids are less than 5
        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titleList = " + titleList);

        //Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(titleList.contains("delectus aut autem"));


    }


}

