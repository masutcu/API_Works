package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoRestDataPojo {
    /*
     "id": 2587,
        "name": "Ganapati Prajapat",
        "email": "prajapat_ganapati@okeefe.org",
        "gender": "female",
        "status": "active"
     */

    //Bu işlemi assert için yapıyoruz.
    //Dolayısıyla id 'yi pojo class'ımızda veriable olarak tanımlamıyoruz.
    //Response data da id'yi görmemek için @JsonIgnoreProperties(ignoreUnknown = true) annotation ile ignore ediyoruz.
    private String name;
    private String email;
    private String gender;
    private String status;

    public GoRestDataPojo() {
    }

    public GoRestDataPojo(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GoRestDataPojo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
