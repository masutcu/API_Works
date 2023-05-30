package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get11 extends HerOkuAppBaseUrl {
     /*
     Given
         https://restful-booker.herokuapp.com/booking/696
     When
    I send GET Request to the URL
   Then
    Status code is 200
And
    Response body is like:
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
    public void get11() {
        //set the url
        spec.pathParams("first","booking","second",696);
        //set the expected data
        //2 kademeli data olduğu için, inner ve outer 2 adet pojo class ihtiyacı var,  oluşturduk.
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("John","Smith",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expected data : "+expectedData);


        //send the request get the response // request rest assured library kullanılarak gönderilir
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //do assertion
        BookingPojo actualData=response.as(BookingPojo.class);
        System.out.println("actual data :"+actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());


    }
}
