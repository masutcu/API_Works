package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponsePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C01_PostRequest extends HerOkuAppBaseUrl{
    /*
    TestCase
     Given
        https://restful-booker.herokuapp.com/booking
    And
        {
            "firstname" : "Jim",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
     When
        Send post request

     Then
        Status code is 200

     And
        Body:
         {
            "bookingid": 1,
            "booking": {
                "firstname": "Jim",
                "lastname": "Brown",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
        }

     */
    public  static int bookingId;
    //post request ile oluşturulan booking id yi get request de kullanmam gerekecek

    @Test
    public void post01(){
        //Set the url
        spec.pathParam("first","booking");
        //set the expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Jim","Brown",111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request get the response
        Response response=given(spec).contentType(ContentType.JSON).body(expectedData).post("{first}");
        response.prettyPrint();

        //do assertion
        BookingResponsePojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        bookingId=response.jsonPath().getInt("bookingid");
        //post request ile oluşturulan booking id yi get request de kullanmam gerekecek
        System.out.println("bookingId = " + bookingId);


    }
}
