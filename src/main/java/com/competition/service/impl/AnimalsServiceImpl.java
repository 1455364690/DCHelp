package com.competition.service.impl;


import com.competition.dao.AnimalsRepository;
import com.competition.model.Animals;
import com.competition.service.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 14553 on 2018/4/29.
 */
@Service("animalsService")
public class AnimalsServiceImpl implements AnimalsService {
    @Autowired
    private AnimalsRepository animalsDao;

    public Animals addAnimals(String img_name, String city, String is_dog, String connect,Timestamp time) {
        Animals animals = new Animals();
        animals.setCity(city);
        animals.setConnect(connect);
        animals.setIsDog(is_dog);
        animals.setImgName(img_name);
        animals.setTime(time);
        return animalsDao.save(animals);
    }
    public Animals findByImgName(String img_name){
        return animalsDao.findByImgName(img_name);
    }
    public long getNumber(){
        return animalsDao.count();
    }
    public List<Animals> getAllAnimals(){
        return (List<Animals>)(animalsDao.findAll());
    }
    public void deleteById(Integer id){
        animalsDao.deleteById(id);
    }
}
