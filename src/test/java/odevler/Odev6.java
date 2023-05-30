package odevler;

import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev6 extends ReqresBaseUrl {
    //1)

  /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void assment06() {
        // Set the url

        spec.pathParams("pp1","api","pp2","unknown");

        // set the expected data

        // send the request get the response

        Response response = given(spec).get("{pp1}/{pp2}");

        //  response.prettyPrint();

        // do assertions

        JsonPath jsonPath = response.jsonPath();

        List<Object> dataList = jsonPath.getList("data.findAll{it.pantone_value}");

        // findAll{it.id<5}.userId}

        System.out.println("dataList = " + dataList);

        // Print all ids greater than 3 on the console
        List<Object> dataList1 = jsonPath.getList("data.findAll{it.id>3}.id");

        System.out.println("dataList1 = " + dataList1);
    // Assert that there are 3 ids greater than 3

        assertEquals(3, dataList1.size());



        // Print all names whose ids are less than 3 on the console

        List<Object> nameList = jsonPath.getList("data.findAll{it.id<3}.name");

        System.out.println("nameList = " + nameList);

        //Assert that the number of names whose ids are less than 3 is 2

        assertEquals(2,nameList.size());


    }





}
