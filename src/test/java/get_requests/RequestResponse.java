package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
/*
1-Postman manuel test icin kullanilir.
2-API otomasyonu icin Rest-Assured Library kullaniyoruz.
3-OTOMASYON KODLARININ YAZIMI ICIN YAPILMASI GEREKEN ADIMLAR :>

i.Gereksinimleri anlama.
ii.Test Case'i yazma ve bu nasil yapilir>>>:
    ii.a) test yazmak icin "Gherkin Language' kullaniyoruz.
    Given kismina on kosullar--> endpoint,Body..
    When :yapilacak islemler--->Get,Put,Delete...
    Then:Coklu islemler-->Donutler-->Assertion,Close...
    And:Ardarda kullanilan ayni islemler icin And kullanilir
 iii) Otomasyon kodlarini yazma.
        1- Set the URL ==> endpointi kur
        2- Set the expected data ==> beklenen veriyi kur
        3- Send the request and get the response ==> Request yolla response al
        4- Do assertion ==> Dogrulama yap.


 */


    public static void main(String[] args) {
    //Get request nasıl yapılır?
        String endpoint=   "https://petstore.swagger.io/v2/pet/999666333";
        Response response= given().get(endpoint);
     //   response.prettyPrint(); //response ı consola yazdırır

        //Status kod nasıl yazdırılır
        System.out.println("Status code : "+response.statusCode());

        //Content Type nasıl yazdırılır:
        System.out.println("Content type : "+response.contentType());

        //Status Line nasıl yazdırılır
        System.out.println("Status Line : "+response.statusLine());

        //Header nasıl yazdırılır
        System.out.println("Header Server : "+response.header("Server"));
        System.out.println("Header Connection : "+response.header("Connection"));
        System.out.println("Header Date : "+response.header("Date"));

        //Headers nasıl yazdırılır:
        System.out.println("-------");
        System.out.println(response.headers());

        //Time nasıl yazdırılır:
        System.out.println("Time : "+response.time());
    }
}
