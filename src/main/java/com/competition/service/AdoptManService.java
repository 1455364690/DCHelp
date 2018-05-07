package com.competition.service;

import com.competition.model.AdoptMan;

import java.sql.Timestamp;

/**
 * Created by 14553 on 2018/5/7.
 */
public interface AdoptManService {
    AdoptMan addAdoptMan(String name, String phone, String address, String animal, Timestamp time,String gender);
}
