package com.competition.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 14553 on 2018/5/7.
 */
@Entity
@Table(name = "adoptman")
public class AdoptMan {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "animal")
    private String animal;

    @Column(name = "time")
    private Timestamp time;

    @Column(name="gender")
    private String gender;

    public AdoptMan() {

    }

    public AdoptMan(String name, String phone, String address, String animal, Timestamp time, String gender) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.animal = animal;
        this.time = time;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
