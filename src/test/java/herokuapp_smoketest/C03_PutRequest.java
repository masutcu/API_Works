package herokuapp_smoketest;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class C03_PutRequest extends HerOkuAppBaseUrl {
       /*
    Given
        https://restful-booker.herokuapp.com/booking/:id

    And
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 100,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
    When
        Send put request

    Then
        Status code is 200

    And
        Body:
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 100,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

    @Test
    public void put01() {
        //Set the url


    }

}
