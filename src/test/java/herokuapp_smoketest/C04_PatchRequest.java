package herokuapp_smoketest;

public class C04_PatchRequest {
      /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
        "totalprice": 111
        }
    When
        Send  patch request
    Then
        Status code is 200
    And
       Body:
        {
        "firstname" : "Ali",
        "lastname" : "Can",
        "totalprice" : 111,
        "depositpaid" : true,
        "bookingdates" : {
            "checkin" : "2018-01-01",
            "checkout" : "2019-01-01"
        },
        "additionalneeds" : "Dinner"
        }
     */

}
