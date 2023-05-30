package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)//default olarak false olduğu için açmak gerekiyor
public class ReqresPojo {
    /*
    {
                "name": "morpheus",
                "job": "leader"
                }
     */
    private  String name;
    private  String job;

    public ReqresPojo(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public ReqresPojo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "ReqresPojo{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
