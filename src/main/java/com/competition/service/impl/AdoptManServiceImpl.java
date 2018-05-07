package com.competition.service.impl;

import com.competition.dao.AdoptManRepository;
import com.competition.model.AdoptMan;
import com.competition.service.AdoptManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by 14553 on 2018/5/7.
 */
@Service("adoptManService")
@Transactional
public class AdoptManServiceImpl implements AdoptManService{

    @Autowired
    private AdoptManRepository adoptManDao;

    public AdoptMan addAdoptMan(String name, String phone, String address, String animal, Timestamp time,String gender) {
        AdoptMan adoptMan = new AdoptMan();
        adoptMan.setName(name);
        adoptMan.setPhone(phone);
        adoptMan.setAddress(address);
        adoptMan.setAnimal(animal);
        adoptMan.setTime(time);
        adoptMan.setGender(gender);
        return adoptManDao.save(adoptMan);
    }
}
