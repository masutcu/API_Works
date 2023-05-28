package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//default olarak false olduğu için açmak gerekiyor
//bu annotation ile, json data pojo classa çevrilirken pojo classta olmayan data, ignore edilir.
public class JsonPlaceHolderPojo {
    /*
    {
       "userId": 55,
       "title": "Tidy your room",
       "completed": false
       }
     */
    //1. wrapper class private veriable'ler oluşturuyoruz
    private Integer userId;
    private  String title;
    private Boolean completed;

    //2. parametreli ve parametresiz constructor'lar oluşturuyoruz

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public JsonPlaceHolderPojo() {
    }
    //3. public getter ve setter lar oluşturuyoruz

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    //4. toString() metodu oluturuyoruz

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
