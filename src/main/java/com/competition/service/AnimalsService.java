package com.competition.service;


import com.competition.model.Animals;

import java.util.List;

/**
 * Created by 14553 on 2018/4/29.
 */
public interface AnimalsService {
    Animals addAnimals(String img_name, String city, String is_dog, String connect);
    Animals findByImgName(String img_name);
    long getNumber();
    List<Animals> getAllAnimals();
}
