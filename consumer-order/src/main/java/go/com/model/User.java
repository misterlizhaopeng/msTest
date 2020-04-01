package go.com.model;

import java.util.Date;

public class User { //implements Serializable
    private Integer id;
    private Date date;
    private String port;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
        this.date = new Date();
    }

    public User(Integer id, String port) {
        this.date = new Date();
        this.id = id;
        this.port = port;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", date=" + date +
                ", port='" + port + '\'' +
                '}';
    }
}
