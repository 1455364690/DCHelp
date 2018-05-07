package com.competition.model;

/**
 * Created by 14553 on 2018/4/29.
 */
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "animals")
public class Animals {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "img_name")
    private String imgName;

    @Column(name = "city")
    private String city;

    @Column(name = "is_dog")
    private String isDog;

    @Column(name = "connect")
    private String connect;

    @Column(name = "time")
    private Timestamp time;

    public Animals() {

    }

    public Animals(String imgName, String city, String isDog, String connect,Timestamp time) {
        this.imgName = imgName;
        this.city = city;
        this.isDog = isDog;
        this.connect = connect;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsDog() {
        return isDog;
    }

    public void setIsDog(String isDog) {
        this.isDog = isDog;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}