package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    /*
    Map<String ,Object> actualData=new ObjectMapper().readValue(response.asString(), HashMap.class);
    bu işlemi yapacagız
     */

    //  <T> T ==> herhangibir data tipini temsil eder obje değildir.
    //  Class<T> cls ==> herhangibir data tipini temsil eder
    public static <T> T convertJsonToJava(String json, Class<T> cls){ //Generic Method
        try {
            return  new ObjectMapper().readValue(json, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
